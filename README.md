# **Hangman game + PostgresSQL database + GUI**


[![JackVey][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]

## Overview
This project aims to create a simple **Hangman** that uses **PostgresSQL** for database. The application will allow gamers to singUp/Login, view their game history and leaderboard. Here are the main features:

1. **Client Authentication**: Users have to Login before accessing the game.
1. **SQL Database**: All the users and games data are stored in postgres server.
3. **Game history**: Players have access to all their previous game infos.
4. **Leaderboard**: Players can view their rank in leaderboard.

### Bulit with
[![Java][Java.badge]][Java-url]
[![CSS][CSS.badge]][CSS-url]
[![Postgres][Postgres.badge]][Postgres-url]
## Project Structure

![UML Diagram][UML.image]

### Java classes
- **HangmanApp**: Main class, loads the login/singUp page.
- **DatabaseManager**: Connects to database a reterives desired infos.
- **Security**: Validates login informations;Entered username and password in sing up page.
- **User**: Stores current gamers username.
- **GameInfo**: Its purpose is to store games info.
- **GamePlay**: Backend of the game page alongside page controller.
- **Other Unmentioned Classes**: They are all controllers for .fxml files.
### Database tables
it is consist of 3 tables: gameinfo, userinfo and animals.
- **Animals**: Storing animal names for game. has on column `name`.
- **GameInfo**: Storing games info. has 6 column:
   - Username: Gamers username that has played the game.
   - Word: Choosen word for the game.
   - WrongGuesses: Number of wrong guesses, the maximum value is 6.
   - Time: Duration of the game.
   - Win: Stores a boolean variable showing that gamer won or lost.
   - GameID: Primary key GameID.
- **UserInfo**: Storing users info. has 3 column:
   - Username: Gamers username.
   - Name: Gamers name.
   - Password: Users password.
 

## Image of program
**Login page**

![loginPage.image]

**Main page**

![mainPage.image]

**Game page**

![gamePage.image]


## How to use?
1. Clone the project using following code
   - `git clone https://github.com/JackVey/Hangman.git`
2. **IDE Setup**: Use IntelliJ or any other IDE of your choice. It is recommended to use IntelliJ along Maven.
3. Install java fx and add its lib folder to the projects libraries.
4. Configure the database address, username and password in `DatabaseManager.java`.
```java
    private static final String jdbcUrl = "";
    private static final String username = "";
    private static final String password = "";
``` 
5. First Start the server and then the UIApplication
6. Enjoy!

## License
Distributed under the MIT License. See `LICENSE.txt` for more information.

## Contact

My Gmail - varin.rain3@gmail.com


> [!IMPORTANT]
> Do not skip how to use steps!.
> [!WARNING]
> You are going to be unable to run the application if you do not import java fx into project properly.

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/JackVey/Hangman.svg?style=for-the-badge&logo=github&logoColor=violet
[contributors-url]: https://github.com/JackVey/Hangman/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/JackVey/Hangman?style=for-the-badge&logo=github&logoColor=violet&color=orange
[forks-url]: https://github.com/JackVey/Hangman/forks
[stars-shield]: https://img.shields.io/github/stars/JackVey/Hangman.svg?style=for-the-badge&logo=github&logoColor=violet
[stars-url]: https://github.com/JackVey/Hangman/stargazers
[issues-shield]: https://img.shields.io/github/issues/JackVey/Hangman.svg?style=for-the-badge&logo=github&logoColor=violet&color=yellow
[issues-url]: https://github.com/JackVey/Hangman/issues
[license-shield]: https://img.shields.io/github/license/JackVey/Hangman?style=for-the-badge&color=purple
[license-url]: https://github.com/JackVey/Hangman/blob/develop/LICENSE
[UML.image]: https://github.com/JackVey/Hangman/assets/161158007/c472bf1d-00e1-4cea-922c-88012ae62ce9
[Java.badge]: https://img.shields.io/badge/Java-%23ED8B00.svg?logo=openjdk&logoColor=white
[CSS.badge]: https://img.shields.io/badge/CSS-1572B6?logo=css3&logoColor=fff
[Postgres.badge]: https://img.shields.io/badge/Postgres-%23316192.svg?logo=postgresql&logoColor=white
[Java-url]: https://www.java.com/
[CSS-url]: https://www.w3.org/Style/CSS/Overview.en.html
[Postgres-url]: https://postgresql.org/
[loginPage.image]: https://github.com/JackVey/Hangman/assets/161158007/03f7d139-26d6-4b7b-ae3f-c7846b5c15dd
[gamePage.image]: https://github.com/JackVey/Hangman/assets/161158007/5dacfc04-dbe7-4acf-81f2-0be71397a60a
[mainPage.image]: https://github.com/JackVey/Hangman/assets/161158007/742c8225-21d0-43b9-a60c-d548b46f8ecf
