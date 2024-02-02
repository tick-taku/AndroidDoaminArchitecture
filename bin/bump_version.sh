#!/bin/bash

libs_file_path="gradle/libs.versions.toml"

version="$1"
versions=(${version//./ })

sed -i -e "/versionMajor/s/.*/versionMajor = \"${versions[0]}\"/g" $libs_file_path
sed -i -e "/versionMinor/s/.*/versionMinor = \"${versions[1]}\"/g" $libs_file_path
sed -i -e "/versionPatch/s/.*/versionPatch = \"${versions[2]}\"/g" $libs_file_path
rm -rf "$libs_file_path-e"
