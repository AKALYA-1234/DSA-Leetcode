select p.firstName,p.lastName,a.city,a.state
 from Person p
 left Join Address a
 on p.PersonId=a.PersonId;
