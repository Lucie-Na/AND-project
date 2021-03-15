# README
# MyCozyLib
<div style="text-align: right"> by Naffien Lucie<br>Student number : 310573 </div>

## Table of Contents

  - [Description](#description)
  - [MoSCoW prioritized requirements](#moscow-prioritized-requirements)
    - [**Must have :**](#must-have-)
    - [**Should have :**](#should-have-)
    - [**Could have :**](#could-have-)
    - [**Won't have :**](#wont-have-)

## Description

This project is a part of the Android course from the ICT cursus for international students of Via University College, in Denmark.<br>
It is very common for people who likes to read, and maybe collection, books, to not know anymore which book they have, and where they store it. This is an application that would help people keep in track all the books they have in their library, whether it is novels, comics, manga, or magazines. It allows them to easily sort, group and find their books, so they will not buy them in duplicate by mistake anymore. With the custom tag system, they can know in which of their bookshelf it is, if they lent it, to who, and everything they could need to know about it.

## MoSCoW prioritized requirements

### **Must have :**
- [ ] connection page :
  - [ ] with a welcome message
  - [ ] asking for user's login
  - [ ] asking for user's password
  - [ ] with a link to make a new account
  - [ ] with a link if the user has forgotten its password
  - [ ] with a button to connect

- [ ] a page to create a new account, asking for :
  - [ ] user's login
  - [ ] user's password
  - [ ] user's security question

- [ ] a page to reset password if the user forget it. It will ask the security question (that will not be needed if the application send an email to the user, if he previously verified it), and if it is correct, the new password

- [ ] a button to return to the last page
- [ ] informations about on which page the user is
- [ ] a navigation bar

- [ ] a page with book informations with :
  - [ ] basic book informations (title, author, resume, type, genre, series name, cover picture, release date, editor...)
  - [ ] the possibility to add or delete a tag to this book
  - [ ] a button to add or remove it to the user's library
  - [ ] a button to add or remove it to the wishlist

- [ ] user's library :
  - [ ] displays all the books the user has added
  - [ ] the possibility to filter them according to tags, title, author...
  - [ ] the possibility to sort books
  - [ ] a button to add a new book by :
    - [ ] its basics informations
    - [ ] its ISBN code
  - [ ] the possibility to delete a book

- [ ] user's whislist, with the same functionnalities as the library

- [ ] seetings page :
  - [ ] to change user's informations :
    - [ ] change his password
    - [ ] delete the password. In that case, it won't be asked to login

### **Should have :**
- [ ] on the setting page :
  - [ ] change user's information :
    - [ ] change his profile picture :
      - [ ] with a picture from his device
      - [ ] with a picture from the defaults ones
    - [ ] add and verified an email address
    - [ ] change language

- [ ] send an email to reset password if the email has been verified
- [ ] on the book description, links to the description of related books

- [ ] on the user's library page :
  - [ ] if the application can't find the book the user is looking for, suggest him : 
    - [ ] books he does not have
    - [ ] to manually add a book
    - [ ] the possibility to group books by tags (author, series name...)


- [ ] propose him other kind of view : list and mosaic
- [ ] another way to add a book : scan its bar code

### **Could have :**
- [ ] a custom welcome message. The user could select the messages he wants to see among the default ones and add a custom one. If only one is selected, the message will always be the same. If none is selected, he can not validate his selection.
- [ ] the possibility to have other users accounts on the same device
- [ ] restore user's data from a file
- [ ] add comments to a book
- [ ] rate books
- [ ] let the user choose what will be working without an internet connection, and letting him know what are the consequences
- [ ] custom theme (background, font...)
- [ ] other ways to add a book :
  - [ ] scan its cover
  - [ ] scan its edge
- [ ] a page with book recommendations
- [ ] news about the books the user is interested in (new release, events...)
- [ ] share a book on another application

### **Won't have :**
- propose default pictures with book symbols
- restore user's data with his mail, login, and password
- a tutorial about how to use the application
- anything about social : see other people comments on a book, see the average note of a book, have a friend list, the possibility to talk with people interested in the same book, report people, filter spoils and bad words, make audio and video call, organize and participate to social events
- add or remove a book from the library by voice command
- read everything on the page for visually impaired people 
- propose another kind of view : an interface with bookshelves the user can organize however he wants. He can add or remove a bookshelf, chose its color and type among the suggested one, move it to another location on the page, organize the books inside... Differents automatical sortens are propose. He can only add books he has in its library