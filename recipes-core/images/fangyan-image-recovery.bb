SUMMARY = "Dashboard Recovery Image"
SECTION = "fangyan"

require fangyan-image.inc

BAD_RECOMMENDATIONS += " \
    qtbase-fonts-ttf-vera \
"

require fangyan-common-packages.inc

IMAGE_INSTALL += "util-linux catprogress packimg"
