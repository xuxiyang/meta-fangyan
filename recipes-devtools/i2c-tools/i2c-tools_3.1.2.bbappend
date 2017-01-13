FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRC_URI = " \
    file://i2c-tools-3.1.2.tar.bz2 \
    file://Module.mk \
"

SRC_URI[md5sum] = "1a4843eb0471ce17aa50bff0a48f7d3d"
SRC_URI[sha256sum] = "ca0cab3729e67c44e2da08f498856dfd09f1125cf17ee2f73ca51c259fcd3d36"
