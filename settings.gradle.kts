rootProject.name = "kt-test"
buildCache {
    local {
        isEnabled = true
        directory = File(rootDir, "build-cache")
    }
}