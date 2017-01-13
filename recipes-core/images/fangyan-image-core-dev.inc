require fangyan-image.inc

IMAGE_FEATURES += "package-management"

OPKG_BUILD_MACHINE ?= "${MACHINE_CLASS}"
OPKG_DOWNLOAD_SERVER ?= "yocto.fangyan.org"

PACKAGE_FEED_URIS += "http://${OPKG_DOWNLOAD_SERVER}/${DISTRO}/${DISTRO_VERSION}/${OPKG_BUILD_MACHINE}/${IMAGE_PKGTYPE}"

require fangyan-common-packages.inc
