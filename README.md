# WolfieMeetsBagel Developer's Guide

## Authors
* Joey Colaizzo [joseph.colaizzo@stonybrook.edu](mailto:joseph.colaizzo@stonybrook.edu)
* Joey Jiemjitpolchai [joey.jiemjitpolchai@stonybrook.edu](mailto:joey.jiemjitpolchai@stonybrook.edu)
* Siyuan Zou [siyuan.zou.1@stonybrook.edu](mailto:siyuan.zou.1@stonybrook.edu)

## Purpose

This document will serve as documentation for all improvements that were made to the user interface for the extra credit section of the project.

## Overall Improvements

* Added WolfieMeetsBagel logo to home page.

## User Side

* Upon logging in, a user may pick which profile they want to log in as
* Session saving for user has been removed (there were too many bugs that popped up when implementning profile picking with session saving enabled for user)
* User can set the location and time/date of a date
* comment date and cancel date have been split up to two pages. A user can comment on a past date, and cancel a pending date.

## Manager Side

* Customer rep no longer appears as their SSN, but rather their full name
* View date requires the manager to enter a customer's first and last name seperately rather than as one string of text
* View Highest Revenue Generator customer no longer shows a list of customer (it didn't make sense to show if a list if we want the "max revenue customer"). 
This feature only displays one customer and the revenue they generated
* Backup Database asks the manager for the DB username, password, DB name, and back up file name.

### Find Dated Users

* Changed the search functionality to be by SSN since that is the primary key for customers
* Display SSN and name of the dated users, since a manager would probably like to see names here

### Add Customer

* Removed erroneous email constraint on SSN
* Included error message if something goes wrong when submitting so that the user knows the customer was not added

### Edit Customer

* Made SSN readonly, since a user's SSN cannot change
* Included error message if something goes wrong when submitting so that the user knows the customer was not added

### Show Date Suggestions

* Updated customer side to show only the names and contact information of people they are suggested to go on a date with, to make consistent with our understanding of what a date suggestion is
* Unified customer representative and customer side into one controller and JSP page, removing duplicity from system
