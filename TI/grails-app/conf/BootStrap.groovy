import com.cland.*
class BootStrap {

    def init = { servletContext ->
		def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
		def userRole = new Role(authority: 'ROLE_USER').save(flush: true)		
		Person p = new Person(firstName:"Jay",lastName:"Bond",gender:"Male",email:"jay@mail.com")
		p.save(flush:true)
		if(p.hasErrors()) println(p.errors)
		
		User adminUser = new User(username:"admin",password:"passowrd",enabled:true,person: p).save(flush:true)
		adminUser.save(flush:true)
		println("Errors? " + adminUser.hasErrors())
		if(adminUser.hasErrors()){
			
			 println(adminUser.errors)
		}else{
			UserRole.create adminUser,adminRole
		}

		
		new Person(firstName:"Kerry",lastName:"Hoyer-Weaver",gender:"Male",email:"jay@mail.com").save()
		new Person(firstName:"Allan",lastName:"Greathead",gender:"Male",email:"jay@mail.com").save()
		new Person(firstName:"Ablan",lastName:"Greathand",gender:"Male",email:"jay@mail.com").save()
		new Person(firstName:"Aclan",lastName:"Greatfinger",gender:"Male",email:"jay@mail.com").save()
		new Person(firstName:"Aclan",lastName:"Greatjob",gender:"Male",email:"jay@mail.com").save()
		new Person(firstName:"Aglan",lastName:"Greattut",gender:"Male",email:"jay@mail.com").save()
		new Person(firstName:"Aglan",lastName:"Greatstuff",gender:"Male",email:"jay@mail.com").save()
		new Person(firstName:"Ablan",lastName:"Greatpoint",gender:"Male",email:"jay@mail.com").save()
		new Person(firstName:"Allannne",lastName:"Greathead",gender:"Male",email:"jay@mail.com").save()
		new Person(firstName:"Anna",lastName:"Thomas",gender:"Male",email:"jay@mail.com").save()
		new Person(firstName:"James",lastName:"Columbus",gender:"Male",email:"jay@mail.com").save()
		new Person(firstName:"Joe",lastName:"Charles",gender:"Male",email:"jay@mail.com").save()
		new Person(firstName:"Mike",lastName:"Rust",gender:"Male",email:"jay@mail.com").save()
		new Person(firstName:"Sarah",lastName:"Johnson",gender:"Male",email:"jay@mail.com").save()
		new Person(firstName:"Michelle",lastName:"Zulu",gender:"Male",email:"jay@mail.com").save()
		new Person(firstName:"Candy",lastName:"Botha",gender:"Male",email:"jay@mail.com").save()
		new Person(firstName:"Tammy",lastName:"Davis",gender:"Male",email:"jay@mail.com").save()
		new Person(firstName:"Tom",lastName:"Malan",gender:"Male",email:"jay@mail.com").save()
		new Person(firstName:"Michael",lastName:"Cral",gender:"Male",email:"jay@mail.com").save()
		new Person(firstName:"Mary",lastName:"Malan",gender:"Male",email:"jay@mail.com").save()
		new Person(firstName:"Bridget",lastName:"Noah",gender:"Male",email:"jay@mail.com").save()
		new Person(firstName:"Raymond",lastName:"Smith",gender:"Male",email:"jay@mail.com").save()
		new Person(firstName:"Ronald",lastName:"Masakadza",gender:"Male",email:"jay@mail.com").save()
		new Person(firstName:"Xholani",lastName:"Bolond",gender:"Male",email:"jay@mail.com").save()
		new Person(firstName:"David",lastName:"Bendila",gender:"Male",email:"jay@mail.com").save()
		new Person(firstName:"Elroy",lastName:"croBond",gender:"Male",email:"jay@mail.com").save()
    }
    def destroy = {
    }
}
