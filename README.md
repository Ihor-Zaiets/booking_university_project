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

(28.10.2023)

I copied idea of BaseServiceImpl from my work project, but now, when i want to cover it in tests, it`s driving me crazy.
I still cannot decide what consider a good\bad code\test practise and how to be sure, that i cover this implementation
right, so every extend will be tested on that functionality automatically.

Okay, so after long frustration and strong misunderstanding of how to deal with it, I decided to delete all code,
i do not understand, because i see, that i collapsed under all new things that came at once.

That day at the evening:

Finally i finished BaseService tests. I even returned almost half of what i deleted previously.
Really step by step strategy helped me with it. Not that, i did not know about it, but somehow this time it just
was what it was.

(29.10.2023)

I knew i would have problems with Reservation, but did not except that much. For whatever reason, PostgreSQL just will
not cast text to reservation_status, so to enable Reservation saving, i must to migrate data type from reservation_status
to text.

Then, i\`m not sure, if i wrote tests good enough for reservation crud. Should\`ve i mocked User and Apartment or is it ok.

Anyway, i finally finished first step and created CRUD for all basic Entities.

(31.10.2023)

So everything was good. I created Validation class. Tests + validations all is good as could be, but then I found out, 
that created by me methods save\delete are public. That is not something i wanted. They should private or protected. 
It was a moment, when i learned a minus of interfaces. All their methods must be public. After that i started writing
implementation through abstract class BaseServiceImpl. An idk why, but this time everything was just working. Truly
I was overwhelmed by many new things in the beginning. So everything was good. Tests, then methods in class. 

And there is now new problem. I cannot test protected or private methods. I started googling. Turned out, i shouldn\`t
test private methods. If i should, then, i wrote them wrong. At first I had kind of good practises collision 
**TDD** vs **private methods**. But know i think, i kind of get it. Public API vs private methods. Also found new topic
to google. JaCoCo.