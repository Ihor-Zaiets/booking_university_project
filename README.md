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

I copied idea of BaseServiceImpl from my work project, but now, when I want to cover it in tests, it's driving me crazy.
I still cannot decide what consider a good/bad code/test practise and how to be sure, that I cover this implementation
right, so every extend will be tested on that functionality automatically.

Okay, so after long frustration and strong misunderstanding of how to deal with it, I decided to delete all code,
I do not understand, because I see, that I collapsed under all new things that came at once.

That day in the evening:

Finally, I finished BaseService tests. I even returned almost half of what I deleted previously.
Really step by step strategy helped me with it. Not that, I did not know about it, but somehow this time it just
was what it was.

(29.10.2023)

I knew I would have problems with Reservation, but did not except that much. For whatever reason, PostgresSQL just will
not cast text to reservation_status, so to enable Reservation saving, I must migrate data type from reservation_status
to text.

Then, I'm not sure, if I wrote tests good enough for reservation crud. Should've I mocked User and Apartment or is it ok.

Anyway, I finally finished first step and created CRUD for all basic Entities.

(04.11.2023)

In the first time I successfully mocked all dependencies end write an isolated tests, although, it happened in my work
project, not here. I could have tried to implement this here, but I'm exhausted of re-writing current project.
My enthusiasm is not infinite and I already want to finish this project ASAP. So I decided to decline all my refactors
and keep save and delete methods public. 

I'm currently trying to implement user authorization and from what I see, it's contained in spring security. I found just 
a beautiful tutorial, but when I tried to extend WebSecurityConfigurerAdapter from spring security module, there was no
such class at all. Luckily, my work project already had all that implemented, so I checked it. the problem was in versions
of spring security. In my project it was 5.4.5. I installed 6.0.14. I also remembered version numbering convention X.Y.Z
Where X is when some backward incompatible changes is made. Like deleting some of the tutorial classes I needed. I decided
to not go for another tutorial and just configure it on old version, since, I just need to implement that functionality 
for my university project. 

Later that day

Okay, now I have problems with dependency versions. I decided to find another tutorial, but again, there was 
used WebSecurityConfigurerAdapter. As I suspect, if in 5.4.5 version of spring security this class looks completely ok,
but in spring-security-config 5.7.11 this class annotated as deprecated and then, as we know in 6.Y.Z this class is no 
longer present. Problem is, when using not latest versions, there may be conflicts and I already met few. So I decided 
to change spring-boot-parent version, so it would completely download me whole project of desired version. I've got another
error. Annotations on me Apartment entity does not work, because jakarta package is missing. I guess, I need to find 
some tutorial on 6.Y.Z spring security package.

(09.11.2023)

I already created all controller and endpoints, dtos and services methods. Today I started implementing services methods
and wanted to use DozerBeanMapper to map dto with entity and vise-versa. And I met a lot of technical difficulties.
map method is not static, so I need object of this class. If I need object, I need inject dependency. I tried to use
@Autowired but got exception "no bean of ... found". That was a moment when I found out about @Configuration and @Bean 
definition. So now I created mu configuration class and defined Bean of DozerBeanMapper. Now Autowired does not throw me 
exception. 

And gosh, constructor DI is so annoying. I like Field DI much more. It is said, that it's not recommended, so I decided
to try a good practise, but in work I didn't meet any problem with field injection, but I meet a lot of problems with
constructor DIs.

Also, I think I'm doing this project at worst time. Even DozerMapper has new 6.X.Y version and a lot of things have changes.
no more available new DozerBeanMapper() constructor. 
Now I have to do something like that (DozerBeanMapper) DozerBeanMapperBuilder.buildDefault();

(11.11.2023)

Today I tried to implement some front-end, cuz my tutor said it`s required for presentation. Gosh, i hate front-end. 
I tried, i failed. Hard, complicated, unknown technology for me. Guess, next time i'd try to convince him, 
that front-end is not required and never was.

Also today I for the first time wrote tests for repository. ... took a long time to do

(16.11.2023)

A few days ago i spoke tu my tutor. Front is required. Without it commission just wouldn't understand what my 
project is doing.
I'm learning typescript now.

(20.11.2023)

I finished getting started with typescript tried to write web application on raw typescript, didn't go well.
Then I installed Angular and started working with it, and oh my Gosh! On 8 November 2023 was released Angular 17. 
I have a problem now, that "Can't bind to '{ngModel}' since it isn't a known property of 'input'." And whole internet 
telling me to add dependency into app.module.ts and of course it does not exist anymore and wherever i'm adding this
dependency it doesn't work.

Ok, so i added it to app.component.ts and todos.component.ts so it was override, idk.

Also, I spend evening trying to figure out, why am i getting red error from Intellij Idea and how to fix it. Turned out,
it was idea's bug and i just needed to ignore that highlight, because everything was working.
