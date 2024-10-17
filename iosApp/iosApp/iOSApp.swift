import SwiftUI
import ComposeApp

@main
struct iOSApp: App {
    init() {
        IosApplicationKt.iosInitKoin()
    }
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}