# Overview
The intent of this project is to provide a quasi prioritized to-do list for an emigrant who just arrived in the US. A new emigrant is likely a bit overwhelmed with everything that they need to do, should do, and could do. With a seemingly endless to-do list and so many complex resources available, the primary goal of this app is to provide an "aha moment" starting point with links to valuable and appropriate resources.

A users experience starts with a welcome page where they will set a zip code, their preferred language, see a welcome message, and an emigration related news feed. From here, they can drill down on the "Need to Knows" like "get an I-94#" and "Get a Work Permit". Each "Need to Know" link will take them to a page that has brief description, a link of relevant resources, and if appropriate a Google Map of relevant locations with 250 miles".

An Admin will be able to login to add more admins, edit the content on each page, and add new "Need to Knows".

# Features
- User login: a user can track keymile stones in navigating the the emigration process.
- Admin Login: Admins will be able to manage Logins, edit site content/UI, and add a new "Want To", "FAQ", and "links".

- RSS Feed: The landing page will have a News feed with relevant update news regarding emigration.
- Add: Admins will have the ability to add a new "Need to Know", which includes a title, description, specific links regarding this topic, and any values needed for the Google API.
- CMS Edit: Admins will have the ability to edit the landing page, about us, and all "need to knows".
- Google Maps API: If appropriate, a "Need to Know" page will include a Google Map
- Google Language API: On the landing page, a user will be able to set the language for the site.


# Technologies
- Java
- Spring Boot
- Spring Security
- Thymeleaf & Thymeleaf Security Extra
- Javascript
- HTML
- CSS
- Bootstrap
- MySQL

# What the Team Will Have to Learn
- [ ] We plan to host this site, so we need to determine an appropriate host, how to generate the appropriate files to upload to the host, and how to configure the host.
- [ ] Google Maps API (Google Maps based on a search term, and proximity from a zip code
- [ ] Google API (language options)
- [ ] RSS Feed Source unknown API
- [x] How to manage logins/Roles to determine varying site access.
- [x] A much deeper level of Thymeleaf to create a true CMS.

# Project Tracker
https://trello.com/b/scrGqFqr/liftoffaug2021b
