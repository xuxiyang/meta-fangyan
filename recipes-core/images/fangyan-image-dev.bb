SUMMARY = "Dashboard Dev Image"
SECTION = "fangyan"

require fangyan-image-core-dev.inc

IMAGE_FEATURES += "ssh-server-openssh"
IMAGE_INSTALL += "openssh-keys"

IMAGE_ROOTFS_EXTRA_SPACE = "15360"

IMAGE_INSTALL += " \
    qtserialport \
    qtbase-fonts \
    qtbase-plugins \
    qtdeclarative-qmlplugins \
    qtquickcontrols-qmlplugins \
    qtquickcontrols2-qmlplugins \
    qtgraphicaleffects-qmlplugins \
"

# gcc sanitizers
IMAGE_INSTALL += "libasan libubsan"

IMAGE_INSTALL += "packagegroup-qt5-qtcreator-debug gdb"
IMAGE_INSTALL += "mtd-utils mtd-utils-ubifs"
#IMAGE_INSTALL += "glitem-qmlplugins imageitem-qmlplugins"

IMAGE_INSTALL += "iperf mpfr i2c-tools ncurses catprogress bonnie++"
