require recipes-core/images/core-image-minimal.bb

inherit extrausers
EXTRA_USERS_PARAMS ?= "usermod -P fangyan root;"
EXTRA_USERS_PARAMS_imx6qwisehmi-vita = "usermod -U root;"

BAD_RECOMMENDATIONS += " \
    qtbase-fonts-pfa \
    qtbase-fonts-pfb \
    qtbase-fonts-qpf \
    qtbase-fonts-ttf-dejavu \
"

IMAGE_OVERHEAD_FACTOR = "1.1"
