# 📚 Simple Library Management System

[![Java](https://img.shields.io/badge/Java-11+-orange.svg)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![GitHub issues](https://img.shields.io/github/issues/Saks29/Simple-Library-Management-System)](https://github.com/Saks29/Simple-Library-Management-System/issues)
[![GitHub stars](https://img.shields.io/github/stars/Saks29/Simple-Library-Management-System)](https://github.com/Saks29/Simple-Library-Management-System/stargazers)

A comprehensive console-based Library Management System built in Java that provides an intuitive interface for managing library operations including book inventory, borrowing/returning, and statistical reporting.

## 🎯 Key Features

✅ **Complete Book Management** - Add, view, and organize books with categories  
✅ **Smart Search System** - Search by title, author with partial matching  
✅ **Borrowing Tracking** - Real-time borrowing status with date tracking  
✅ **Category Organization** - Organize books into meaningful categories  
✅ **Statistics Dashboard** - Comprehensive library analytics  
✅ **User-Friendly Interface** - Clean console menu with visual indicators  
✅ **Date Management** - Automatic date tracking for all transactions  
✅ **Availability Status** - Real-time book availability monitoring  

## 🚀 Quick Start

### Prerequisites
- Java 8 or higher installed
- Command line access

### Installation & Run

```bash
# Clone the repository
git clone https://github.com/Saks29/Simple-Library-Management-System.git

# Navigate to project directory
cd Simple-Library-Management-System

# Compile the program
javac LibraryManagementSystem.java

# Run the application
java LibraryManagementSystem
```

## 📋 Menu Overview

The system provides a comprehensive menu with these options:

| Option | Feature | Description |
|--------|---------|-------------|
| 1 | 📚 Display All Books | View complete inventory |
| 2 | ➕ Add New Book | Add books to collection |
| 3 | 🔍 Search Books | Search by title/author |
| 4 | 📖 Borrow Book | Check out books |
| 5 | 📤 Return Book | Return borrowed books |
| 6 | 📗 Available Books | View only available books |
| 7 | 📕 Borrowed Books | View currently borrowed books |
| 8 | 📂 Category View | Browse by categories |
| 9 | 📊 Statistics | Library analytics dashboard |
| 0 | ❌ Exit | Close application |

## 💡 Usage Examples

### Adding a New Book
```
➕ ADD NEW BOOK
================
Enter book title: Clean Code
Enter author name: Robert C. Martin  
Enter category: Programming
✅ Book added successfully: Clean Code
```

### Borrowing a Book
```
📖 BORROW BOOK
===============
Enter Book ID to borrow: 1
Enter borrower name: John Doe
✅ Book 'The Java Programming Language' borrowed successfully by John Doe
📅 Borrow Date: 20-07-2025
```

### Viewing Statistics
```
📊 LIBRARY STATISTICS:
==============================
📚 Total Books: 6
📗 Available Books: 4
📕 Borrowed Books: 2
📂 Categories: 3

📂 Books by Category:
   • Programming: 2 books
   • Computer Science: 2 books
   • Fiction: 2 books
```

## 🏗️ Architecture

### Core Components

- **`Book` Class**: Represents individual books with all properties
- **`Library` Class**: Manages all operations and data storage
- **`LibraryManagementSystem` Class**: Handles user interface and menu system

### Design Principles

- **Object-Oriented Design**: Clean separation of concerns
- **Data Encapsulation**: Private fields with controlled access
- **Efficient Storage**: HashMap for category-based organization
- **Date Management**: Built-in date tracking with formatting

## 🔧 Technical Specifications

- **Language**: Java 8+
- **Storage**: In-memory (ArrayList + HashMap)
- **Dependencies**: Java Standard Library only
- **Interface**: Console-based with formatted output
- **Data Persistence**: Runtime only (no external database)

## 📂 Project Structure

```
Simple-Library-Management-System/
│
├── LibraryManagementSystem.java    # Main application file
├── README.md                       # Project documentation  
├── LICENSE                         # MIT License
├── .gitignore                     # Git ignore patterns
└── docs/                          # Additional documentation
    ├── screenshots/               # Application screenshots
    └── CONTRIBUTING.md           # Contribution guidelines
```

## 🚧 Roadmap & Future Enhancements

### Phase 1 - Core Improvements
- [ ] **File Persistence** - Save/load data from files
- [ ] **Input Validation** - Enhanced error handling
- [ ] **Unit Tests** - Comprehensive test coverage

### Phase 2 - Advanced Features  
- [ ] **Database Integration** - MySQL/SQLite support
- [ ] **Due Date System** - Fine calculation for overdue books
- [ ] **Member Management** - User accounts and profiles
- [ ] **Reservation System** - Book reservation queue

### Phase 3 - Modern Interface
- [ ] **GUI Version** - JavaFX interface
- [ ] **Web Interface** - Spring Boot web application
- [ ] **Mobile App** - Android/iOS versions

## 🤝 Contributing

We welcome contributions from the community! Here's how you can help:

1. **🍴 Fork** the repository
2. **🌟 Create** a feature branch (`git checkout -b feature/amazing-feature`)
3. **✅ Commit** your changes (`git commit -m 'Add amazing feature'`)
4. **🚀 Push** to branch (`git push origin feature/amazing-feature`)
5. **📝 Open** a Pull Request

### Development Guidelines

- Follow Java naming conventions
- Write clear, commented code
- Test thoroughly before submitting
- Update documentation as needed

See [CONTRIBUTING.md](docs/CONTRIBUTING.md) for detailed guidelines.

## 🐛 Issues & Support

Found a bug or need help? 

- 📋 Check existing [Issues](https://github.com/Saks29/Simple-Library-Management-System/issues)
- 🐛 Report bugs with detailed steps to reproduce
- 💡 Suggest features with clear use cases
- ❓ Ask questions in [Discussions](https://github.com/Saks29/Simple-Library-Management-System/discussions)

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- Built with Java's robust standard library
- Inspired by real-world library management needs  
- Designed for educational and practical use
- Community feedback and contributions welcome

## 📊 Project Stats

![GitHub language count](https://img.shields.io/github/languages/count/Saks29/Simple-Library-Management-System)
![GitHub top language](https://img.shields.io/github/languages/top/Saks29/Simple-Library-Management-System)
![GitHub code size](https://img.shields.io/github/languages/code-size/Saks29/Simple-Library-Management-System)

---

<div align="center">

**⭐ Star this repository if you found it helpful!**

Made with ❤️ by [Saks29](https://github.com/Saks29)

[Report Bug](https://github.com/Saks29/Simple-Library-Management-System/issues) • [Request Feature](https://github.com/Saks29/Simple-Library-Management-System/issues) • [Contribute](https://github.com/Saks29/Simple-Library-Management-System/pulls)

</div>
