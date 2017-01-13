SUMMARY = "Dashboard Core Image"
SECTION = "fangyan"

require fangyan-image-core-dev.inc

DESCRIPTION = "fangyan core image"

IMAGE_ROOTFS_EXTRA_SPACE = "20480"

IMAGE_FEATURES += "ssh-server-dropbear"
IMAGE_INSTALL += "dropbear-keys"

BAD_RECOMMENDATIONS += " \
    qtbase-fonts-ttf-vera \
"
