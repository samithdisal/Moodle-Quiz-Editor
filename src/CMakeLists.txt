
file(GLOB MQE_SRC *.cpp *.h)

find_package(Qt4 REQUIRED QtCore QtGui)
include(${QT_USE_FILE})

add_executable(mqe ${MQE_SRC})
target_link_libraries(mqe ${QT_LIBRARIES})