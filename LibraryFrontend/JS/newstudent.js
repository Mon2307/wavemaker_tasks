// const changeBackground = document.querySelector('.forbackground');
//const formchange= document.querySelector('.newstudent');

function closestudent(){
    // formchange.classList.remove('openform');
    // formchange.classList.add('closeform');
    const addstudentform= document.getElementById('controladdstudent');
   addstudentform.style.display="none";
 
//    changeBackground.classList.toggle('forbackground');
}
function openstudent(){
  // formchange.classList.remove('openform');
  // formchange.classList.add('closeform');
  const addstudentform= document.getElementById('controladdstudent');
   addstudentform.style.display="block";

//    changeBackground.classList.toggle('forbackground');
}

function gotohome(){
    window.location.href="home.html";
}
async function checkstudent(x){
  const r= await fetch(`http://localhost:8080/Library/students/${x}`);
  let find = await r.json();
  
  console.log(find);
  if(find){
    alert('Student Exists Already.');
    form.reset();
    return;
  }
}
function Addstudent(){
    // changeBackground.classList.toggle('afterformopen');
    // formchange.classList.toggle('openform');
    openstudent();
  const form = document.getElementById('addstudent');
  
  form.addEventListener('submit', (e)=>{
      e.preventDefault();
  
      const formData = new FormData(form);
      // const data = new URLSearchParams(formData);
       //Create an object from the form data entries
    let formDataObject = Object.fromEntries(formData.entries());
      // Format the plain form data as JSON

      // for(field in formDataObject ){
      //   if(!field.value){
      //     alert(field+" cannot be empty");
      //   }
      //  }
      
      
      checkstudent(formDataObject.rollNo);
      let formDataJsonString = JSON.stringify(formDataObject);
  
      console.log(formDataJsonString);
      fetch('http://localhost:8080/Library/students/insert', {
        method: 'POST',
        headers: {
            "Content-Type": "application/json",
            Accept: "application/json",
           
          },
          body: formDataJsonString
      }).then((response) => {
          // An important thing to note is that an error response will not throw
          // an error so if the result is not okay we should throw the error
          if(!response.ok) {
            throw response;
          }
      
          // since we expect a json response we will return a json call
          const res = response.json();
           console.log(res);
        //   console.log('Done');
          res.then((student)=>{
              
              console.log(student.studentName);
              swal(student.studentName +" Added Successfully!");
            //   if(book.Name != 0){
            //       // alert("succesfully logged in")
            //       window.location.href = "overview.html"
            //   }else{
            //       alert("Wrong credentials")
            //   }
            document.getElementById("addstudent").reset();
            
          })
        })
  });
}
// api url

var rollno=[];
const api_url =
	'http://localhost:8080/Library/students';

// Defining async function
async function getapi(url) {
	
	// Storing response
	const response = await fetch(url);
	
	// Storing data in form of JSON
	var data = await response.json();
	console.log(data);

    for(r of data){
        console.log(r);
        console.log(r.branchId);
        console.log(r.rollNo);
        rollno.push(r.rollNo);
       if(r.branchId==1){
        r.Branch="CS";
        console.log(r.Branch);
       }
       else if(r.branchId==2){
        r.Branch="IT";
        console.log(r.Branch);
       }
       else if(r.branchId==3){
        r.Branch="EE";
        console.log(r.Branch);
       }
       else if(r.branchId==4){
        r.Branch="ENTC";
        console.log(r.Branch);
       }
       else if(r.branchId==5){
        r.Branch="ME";
        console.log(r.Branch);
       }
        
    }
	if (response) {
		show(data);
	}
    else{
        loader();
    }
	
}
// Calling that async function
getapi(api_url);

// Function to hide the loader
function loader() {
	document.getElementById('loading').style.display;
}
// Function to define innerHTML for HTML table
function show(data) {
	let tab =
		`<tr>
		<th>Roll No</th>
		<th>Email Id</th>
		<th>Name</th>
        <th>Branch</th>
		</tr>`;
	// Loop to access all rows
	for (let r of data) {
		tab += `<tr>
  <td>${r.rollNo}</td>
	<td>${r.mailId} </td>
	<td>${r.studentName}</td>
    <td>${r.Branch}</td>				
</tr>`;
	}

  //<td><button class="btn btn-primary" onclick="editstudent(this)">Edit</button></td>
	// Setting innerHTML as tab variable
	document.getElementById("Students").innerHTML = tab;
}

function editstudent(e){
  var sTable = document.getElementById('Students');

  let index = e.parentNode.parentNode.rowIndex;
  var Cells = sTable.rows.item(index).cells;
 let studentRollNo = Cells[0].innerText;
 let  bookName = Cells[1].innerText;
 
}


function myFunction() {
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("search");
  filter = input.value.toUpperCase();
  table = document.getElementById("Students");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}