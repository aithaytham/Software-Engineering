# Domisep


The goal of the project is to design and develop a platform that acts as an intermediary between a user and the connected objects present in his house. It must allow our client visualization and analysis of the data of its sensors as well as a control of its connected objects.

For this we will create a website allowing the organization of these data and the manipulation of these objects there more effective and secure possible.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 

### Prerequisites

What things you need to install the software and how to install them :

- An Apache HTTP Server
- A MySQL relational database management system
- A Web Browser
- PHP Version >= 7.0

### Installing

A step by step series of examples that tell you have to get a development environment running :


- The url of this repository is: https://github.com/adlambel/Domisep.git
- Then open a git bash or a shell and make the command git clone on the url of this repository and enter your valid Github credentials to clone the repository in the folder of your choice.
- Log in to PhpMyAdmin and launch the SQL dump: dump_sql.sql

You are therefore in possession of the site's database.
By default, there are:

- An administrator account whose identifiers are: admin@admin.fr / admin

- A technician account whose identifiers are: tech@tech.fr / tech

- A customer account whose identifiers are: client@client.fr / customer / session : Master / Pin 1234

Once these steps are done, you are ready to launch the site.

## Running the tests


This site is developed on a Linux environment, it is recommended that you use Linux to test locally.

### Linux

Place the site folder, by default named Domisep in the folder / var / www / html.
On Linux, PHP, Apache and MySQL launch automatically. If this is not the case, launch themdefault it'll be 'domisep', 'root', ''
The site is then accessible via the url: localhost / Domisep.

### Windows / Mac

Download Wamp, select PHP 7.0, and place the Domisep folder in your LAMP/MAMP www / folder.
Launch the services. As soon as the logo appears green, you can access the site.

The site is then accessible via the url: localhost / Domisep

## Lauching

You'll have to edit the mysql login parameters in order to launch the website correctly.
To do this, simply update the Domisep/Config/Config.php getAuthData() function by putting your db host, and your mysql database name and credentials. By default it'll be 'localhost','domisep','root', ''.

## Authors

ISEP Students Group G2A Promotion Year 2020 : 

- Haytham AIT ETTAJER
- Adrien LAMBEL
- François MATHIEU
- Thibault GROUET
- Edouard PIRJANTZ
- Kévin TAN





