#!/bin/sh

folderName='2.1'
mkdir ~/run/apk/Dropbox/APK/$folderName/${BUILD_NUMBER}
mkdir ~/run/apk/Dropbox/APK/$folderName/${BUILD_NUMBER}/mapping
cp App/build/outputs/apk/Target-*.apk ~/run/apk/Dropbox/APK/$folderName/${BUILD_NUMBER}/
cp App/build/outputs/mapping/production/release/* ~/run/apk/Dropbox/APK/$folderName/${BUILD_NUMBER}/mapping/
