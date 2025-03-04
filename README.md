# RemindMe - Android

A feature-rich note taking application for Android with categorization, prioritization, and reminder capabilities, adopting a minimalistic, nag-free approach.

## Features

- **CRUD Operations**: Create, Read, Update, and Delete notes
- **Smart Organization**:
  - Category filtering (Work, Personal, Shopping + custom)
  - Priority-based sorting (High/Medium/Low)
  - Date-based sorting (Creation date/End date)
- **Visual Indicators**:
  - Color-coded priority levels
  - Overdue date highlighting
- **Modern Architecture**:
  - MVVM pattern
  - Room Database persistence
  - LiveData observables
  - Navigation Component

## Prerequisites

- Android Studio Hedgehog | 2023.1.1 or later
- Android SDK 33 (Tiramisu) minimum, 34 recommended
- Java 17

## Installation

1. Clone the repository:
```bash
git clone https://github.com/yourusername/android-notes-app.git
```

2. Open project in Android Studio:
   - File > Open > Select project directory

3. Build the project:
```bash
./gradlew assembleDebug
```

## Usage

1. **Add Note**:
   - Tap + FAB button
   - Fill in note details
   - Select category/priority/dates
   - Save automatically persists to database

2. **Filter/Sort**:
   - Use chip filters for categories
   - Sort menu for date/priority sorting

3. **Edit/Delete**:
   - Tap note to view details
   - Edit/Delete options in detail view

## Screenshots

| List View | Detail View | Add Note |
|-----------|-------------|----------|
| ![List](screenshots/list.png) | ![Detail](screenshots/detail.png) | ![Add](screenshots/add.png) |

## License

MIT License - See [LICENSE](LICENSE) for details

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## Acknowledgments

- Android Jetpack components
- Material Design Components
- [Material DateTime Picker](https://github.com/wdullaer/MaterialDateTimePicker)
