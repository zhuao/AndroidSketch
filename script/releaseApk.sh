#!/bin/sh

# Before run this script, please prepared the right required API key and certification
#   1. Sign file and pass: $ciServer/App-android-key.keystore ; $ciServer/pass.json
#   2. Config file: $ciServer/config.gradle

DIR=$( cd "$( dirname $0 )" && pwd )

ciServer="http://localhost:8000"

cd $DIR
cd ..
./gradlew -PisForPublish=true -PciServer=$ciServer assembleProductionRelease

##sign package

keyFile="App-android-key.keystore"
if [ -f "$keyFile" ]
then
    echo $keyFile
else
	curl -O $ciServer/App-android-key.keystore
fi

pass=$(curl -L $ciServer/pass.json)

releaseFile=$(ls App/build/outputs/apk/App-production-release-*)

jarsigner -sigalg SHA1withRSA -digestalg SHA1 -tsa http://timestamp.digicert.com -storepass $pass -keypass $pass -keystore App-android-key.keystore $releaseFile Appandroidappkey
${ANDROID_HOME}/build-tools/22.0.1/zipalign -f 4 $releaseFile app/build/outputs/apk/App-production-release-signed.apk
rm $releaseFile
mv app/build/outputs/apk/App-production-release-signed.apk $releaseFile
rm -f $keyFile
