SUMMARY = "OpenGL (ES) 2.0 benchmark"
DESCRIPTION = "glmark2 is a benchmark for OpenGL (ES) 2.0. \
It uses only the subset of the OpenGL 2.0 API that is compatible with OpenGL ES 2.0."
HOMEPAGE = "https://launchpad.net/glmark2"
BUGTRACKER = "https://bugs.launchpad.net/glmark2"

LICENSE = "GPLv3+ & SGIv1"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=d32239bcb673463ab874e80d47fae504 \
    file://COPYING.SGI;beginline=5;md5=269cdab4af6748677acce51d9aa13552 \
"

DEPENDS = "libpng12 jpeg"

SRC_URI = "git://github.com/yuq/glmark2.git;protocol=https"
SRCREV = "6ace6bafd9d68f6f10202abed03aabfd7a9db2ef"

S = "${WORKDIR}/git"

inherit waf pkgconfig

PACKAGECONFIG ?= ""

PACKAGECONFIG[fb-imx6-glesv2] = "--with-flavors=fb-imx6-glesv2,,virtual/libgles2"
PACKAGECONFIG[fb-sunxi-glesv2] = "--with-flavors=fb-sunxi-glesv2,,virtual/libgles2"
