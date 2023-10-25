# booking_university_project
Booking service, created as diploma work for university

(25.10.2023) (~ 2 weeks of working on this project)

I try to create new project using known good practises, for now it is TDD and interface dependence 
(better than class dependence). As was said, TDD helps to write clean, simple, modular code.
If it is hard to write test for code, it is mean code is bad. I could have already finished that project,
if I would just repeat already known for me code writing process 
(Entity + Repo + Service + Controller -> CRUD -> whole other business logic), 
but because I first started writing tests, I encountered new problems.

First, I did not know, how TDD process looks like. Googled. Some code was written, looks like got it. 
Done.

Then, There is on my first work, we use field Dependency Injection (DI), I read, it is a bad practise.
The best way to go is constructor DI (and if DI object can change, then setter DI). But I thought, 
"it would be really messy. So many dependencies, those constructors would be horrendous", then I found
these words "yep, and that is right. Constructors with 7+ fields is a signal of bad code, 
and you see it early". Okay, googled, now I know, how it looks like to use constructor DI. Done.

Then, I was testing saving (create from CRUD) to database, so I must have to configure those tests, 
that after each test I have empty database without data from previous test. Googled. Done.

Then, there was Mocking topic. I heard about it, but never really worked with it. I spent a day or two, 
to read series of guides on that topic. Looks like, I got it, at least now I have some understanding, 
but it is still not as known as breathing. Googled. Done

THEN, I did not want to write CRUD test and functionality for each service, especially, 
I saw a good example at work. I created BaseService with generics, so then every service just extends it
and have all CRUD methods. But it was a new topic for me and TDD new too, so I wrote Service first, 
because I did not know what it should look like. I was mostly copying from work project.
And then I started writing tests on that service.

And now I have problems. I do not know, how to write tests on such generic class. I should have extended
this class with some other classes to test it and also mocking. I guess too much new topics met at one point.
Also, I heard, that it is possible to test interfaces too. Following TDD principal "No line of code 
without tests" I should test my Service interface, cus it have some methods. 
But I have absolutely no idea, how interface tests should look like. So now, 
I spend my time googling, how to test interfaces and generic classes and all.