function display(){
    window.location.href = "signup.html";
}

let Librariansmail=[];
let password=[];
fetch('http://localhost:8080/LibraryManagementProject/librarians')
.then((response)=> response.json())
    .then((json)=>{
        json.forEach(librarian=> {
            console.log(librarian.librarianemailId);
            Librariansmail.push(librarian.emailId);
            password.push(librarian.password);
        });
    })
const form = document.getElementById('loginForm');
var found=0;
form.addEventListener('submit', (e)=>{
    e.preventDefault();

       const formData = new FormData(form);
      
        let formDataObject = Object.fromEntries(formData.entries());
      // Format the plain form data as JSON
      let formDataJsonString = JSON.stringify(formDataObject);
      console.log(formDataJsonString );
       
        if ( Librariansmail.includes(formDataJsonString.username)){
            console.log('formDataJsonString.username');
            if(password.includes(formDataJsonString.password)){
                console.log('formDataJsonString.password');
                found=1;
                window.location.href = "homepage.html";
            }
        }
        else{
            alert("No account found");
        }
   
}
)


