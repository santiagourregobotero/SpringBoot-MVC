## Entity-Relationship Model

For the User CRUD option, I need only one table.
The <b>USER</b> table. <br>
The User table consist of these elements.

ID<br>Firstname<br>Name<br>Telephone<br>Email<br>Position<br>Status<br>Role

## JAVA classes

I have only one Java class - User. <br>
It is defined in User.java and This is the code snippet for Entity.

```java
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    public User() {
        super();
    }

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "name")
    private String name;

    ...

    @Column(name = "position")
    private Integer position;
```

And this is my spring boot project structure. <br>

```
project-root
├── controller
│   └── UserController.java
├── db
│   ├── entities
│   │   └── User.java
│   └── repositories
│       └── UserRepository.java
└── service
    └── UserService.java
```
As you can see , I make a service


And Let's see about the business logic for CRUD( Create , Read , Update , Delete). <br>

### CRUD business logic
- Create <br>
I create logic I have used save function of repository. Then save works correctly.
```java
    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        try{
            userService.addUser(user);
            return "Success";
        } catch(Exception e) { return "Error"; }
    }
```
- Read <br>
I have implemented the Reading logic to get all datas from the server.
```java
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
```
- Update <br>
This is the Code for User Update.
```java
    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable Integer id ,@RequestBody User userdetail) {
        try{
            User user = userService.getUser(id);
            user.setFirstname(userdetail.getFirstname());
            user.setName(userdetail.getName());
            user.setTelephone(userdetail.getTelephone());
            user.setEmail(userdetail.getEmail());
            user.setPosition(userdetail.getPosition());
            user.setRole(userdetail.getRole());
            user.setStatus(userdetail.getStatus());
            userService.updateUser(user);
            return "Success";
        } catch(Exception e) { return "Error"; }
    }
```
- Delete <br>
I have implemented Delete User functionality by User Id.
```java
    @DeleteMapping("/remove/{id}")
    public String removeUser(@PathVariable Integer id) {
        try{
            userService.deleteUser(id);
            return "Success";
        } catch(Exception e) { return "Error"; }
    }
```

## Improvements that I can bring to the requirements.
- I can add photo upload functionality to the project so users can upload images to the server.
- I can make project's logic more sophisticated by adding more roles and positions.
- As an artificial intelligence expert, I can add new artificial intelligence functions by using artificial intelligence Java libraries.
Examples include facial recognition.


Currently, CRUD logic does not use complex functions. Since there is no data base manipulation, only data storage, reading, and writing operations are performed.
However, to perform more complex operations, in my opinion, the service layer should be better utilized.
In that sense, I have a wealth of experience in this kind of work.
If a project is complex, I can solve it skillfully.
