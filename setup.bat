@echo off
:: Variables
set PATH=%PATH%;%DIRECTORY%

title Aether II Development Workspace Setup

:: Deleting OLD Eclipse Workspace
IF EXIST eclipse (
echo Deleting OLD eclipse workspace...
del /q /s eclipse >nul
)

:: Call Gradle Setup
call gradlew setupDecompWorkspace eclipse
pause