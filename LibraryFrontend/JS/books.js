const bookstable= document.getElementById("allbooks");
const issuedbookstable= document.getElementById("issuedbooks");
function gotohome(){
    window.location.href="home.html";
}



function closeaddbook(){
    const addForm=document.getElementById("controladdbook");
    addForm.style.display="none";
}

function addbook(){
    const addForm=document.getElementById("controladdbook");
    addForm.style.display="block";
    // document.getElementById("addBook").style.display="block";
    // const open = document.querySelector('.addbookform');
    // open.classList.toggle('addbookopen');
    const form = document.getElementById('addBook');
  
  form.addEventListener('submit', (e)=>{
      e.preventDefault();
      const formData = new FormData(form);
    let formDataObject = Object.fromEntries(formData.entries());
      let formDataJsonString = JSON.stringify(formDataObject);
      console.log(formDataJsonString);
      fetch('http://localhost:8080/Library/books/insert', {
        method: 'POST',
        headers: {
            "Content-Type": "application/json",
            Accept: "application/json",
           
          },
          body: formDataJsonString
      }).then((response) => {
          
          if(!response.ok) {
            throw response;
          }
      
         
          const res = response.json();
           console.log(res);
        //   console.log('Done');
          res.then((book)=>{
              console.log(book.bookName);
              swal(book.bookName + " Added Successfully!")
              document.getElementById("addBook").reset();
          })
        })
  });

}

function showbooks(){
    bookstable.style.display="block";
    issuedbookstable.style.display="none";
    const api_url =
	'http://localhost:8080/Library/books';

// Defining async function
async function getapi(url) {
	
	// Storing response
	const response = await fetch(url);
	
	// Storing data in form of JSON
	var data = await response.json();
	console.log(data);
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
		`
        <thead>
        <tr>
        <th>Book No</th>
		<th>Book Name</th>
		<th>Author</th>
		<th>Publication</th>
    <th>Count</th>
    </thead>
		</tr>`;
	
	// Loop to access all rows
	for (let r of data) {
		tab += `<tbody><tr>
  <td>${r.bookId}</td>
	<td>${r.bookName} </td>
	<td>${r.authorName}</td>
	<td>${r.publication}</td>
  <td>${r.total_copies}</td>			
</tr></tbody>`;
	}
	// Setting innerHTML as tab variable
	document.getElementById("Books").innerHTML = tab;
}


}


function showissuedbooks(){
//   const bookbtn = document.getElementsByClassName('books');
// bookbtn.classList.remove("active");

// const issuedbooks =document.getElementsByClassName('issuebook');
// issuedbooks.classList.add("active");
    bookstable.style.display="none";
    issuedbookstable.style.display="block";
   const issue= document.querySelector("issue");
   const book =document.querySelector("books");
    const api_url ='http://localhost:8080/Library/bookissue/bookissued';

// Defining async function
async function getapi(url) {
	
	// Storing response
	const response = await fetch(url);
	
	// Storing data in form of JSON
	var data = await response.json();
	console.log(data);
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
		<th>Book Name</th>
		<th>Issued Date</th>
        <th>Returned Status</th>
		</tr>`;
	
	// Loop to access all rows
	for (let r of data) {
		tab += `<tr>
  <td>${r.studentRollNo}</td>
	<td>${r.bookName} </td>
	<td>${r.issueDate}</td>  
    <td><button class="returnbtn btn btn primary" onclick="returnbook(this)">Return</button></td>		
</tr>`;
	}
	// Setting innerHTML as tab variable
	document.getElementById("issuedBooks").innerHTML = tab;
}

}

function myFunction() {
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("search");
  filter = input.value.toUpperCase();
  table = document.getElementById("Books");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[1];
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


// function issueBook(){
   
//     const formData = new FormData(form);
//     const form = document.getElementById('issue');
//     let formDataObject = Object.fromEntries(formData.entries());
//       // Format the plain form data as JSON
//       let formDataJsonString = JSON.stringify(formDataObject);
//       console.log(formDataJsonString);
           
//            const bookName = document.getElementById('bookname');
//            console.log('bookName');
// }
    // if user press any key and release
   
 
// function issueabook(){

//     // showbooks();
//     const issuebookform = document.getElementById('issueformhide');
// issuebookform.style.display="block";
// // const  Enteredbookname= Enteredbookname.value;
// function showbooksinlist(){
//     var flag=0;
//     let suggestions = [];
//     fetch('http://localhost:8080/Library/books')
//     .then((response)=> response.json())
//         .then((json)=>{
//             json.forEach(book => {
//                 console.log(book.bookName);
//                 if(book.total_copies){
//                     suggestions.push(book.bookName);
//                 }
    
//                 else{
//                    flag=1;
                   
//                 }
               
//             });
//         })
    
//  }

// // console.log( Enteredbookname);
// // const issueDate=  document.getElementById("issuedate")
// // issueDate.min=new Date().toLocaleDateString('fr-ca');
// inputBox.onkeyup = (e)=>{
//     showbooksinlist();
//     let userData = e.target.value; //user entered data
//     let emptyArray = [];
   
//     if(userData){
//         // icon.onclick = ()=>{
//         //     webLink = `https://www.google.com/search?q=${userData}`;
//         //     linkTag.setAttribute("href", webLink);
//         //     linkTag.click();
//         //     console.log(userData);
//         // }
//         emptyArray = suggestions.filter((data)=>{
//             //filtering array value and user characters to lowercase and return only those words which are start with user entered chars
//             return data.toLocaleLowerCase().startsWith(userData.toLocaleLowerCase());
//         });
//         emptyArray = emptyArray.map((data)=>{
//             // passing return data inside li tag
//             return data = `<li>${data}</li>`;
//         });
//         searchWrapper.classList.add("active"); //show autocomplete box
//         showSuggestions(emptyArray);
//         let allList = suggBox.querySelectorAll("li");
//         for (let i = 0; i < allList.length; i++) {
//             //adding onclick attribute in all li tag
//             allList[i].setAttribute("onclick", "select(this)");
//             console.log(allList[i]);
//             console.log(allList[i].value);
//             var bookName=inputBox.value;
//             console.log(bookName);
           
//         }
//     }else{
//         searchWrapper.classList.remove("active"); //hide autocomplete box
//     }
// }



// function showSuggestions(list){
//     let listData;
//     if(!list.length){
//         userValue = inputBox.value;
//         listData = `<li>${userValue}</li>`;
//     }else{
//       listData = list.join('');
//     }
//     suggBox.innerHTML = listData;
// }
// }


//     const form = document.getElementById('issue');
//     form.addEventListener('submit', (e)=>{
//             e.preventDefault();
            
    
//     const formData = new FormData(form);
//     // const data = new URLSearchParams(formData);
//      //Create an object from the form data entries
 

//   let formDataObject = Object.fromEntries(formData.entries());
// //   checkstudent();

//   console.log(formDataObject.issueDate);
//     //changing date format
//     var oldDate = new Date(formDataObject.issueDate);
//     console.log( oldDate.toLocaleDateString() + "\n" + oldDate.toISOString() + "\n" +
//     oldDate.toDateString() +"\n" + oldDate.toUTCString());
//     var newDate = oldDate.toDateString().substring(4,10) + ", " + oldDate.toDateString().substring(11,);
//     console.log(newDate);
//     formDataObject.issueDate=newDate;
//     //issuetime
    
      
//       formDataObject.issueTime=current_time;
//     let formDataJsonString = JSON.stringify(formDataObject);

//     console.log(formDataJsonString);
//     // function issue(){}
//     fetch('http://localhost:8080/Library/bookissue/insert', {
//       method: 'POST',
//       headers: {
//           "Content-Type": "application/json",
//           Accept: "application/json",
         
//         },
//         body: formDataJsonString
//     }).then((response) => response.text())
//     .then((text) => {
//       var a = text;
//       console.log(a);
//       alert(a);
    
//       })
// })

// }).then((response) => {
    //     // An important thing to note is that an error response will not throw
    //     // an error so if the result is not okay we should throw the error
    //     if(!response.ok) {
    //      throw response;
    //      }
        // const res = JSON.stringify(response);
        // console.log(res);
    //     console.log(response);
    //   console.log(response.json());
    //     alert(JSON.stringify(response));
       // document.getElementById("issue").reset();
        // location.reload();
        // since we expect a json response we will return a json call
        
      //   console.log('Done');
        //  res.then((bookissue)=>{
        //     console.log(bookissue)
        //  })

//returnbookcode


function SetreturnDate()
{
var date = new Date();

var day = date.getDate();
var month = date.getMonth() + 1;
var year = date.getFullYear();

if (month < 10) month = "0" + month;
if (day < 10) day = "0" + day;

var today = year + "-" + month + "-" + day;
var oldDate = new Date(today);
    console.log( oldDate.toLocaleDateString() + "\n" + oldDate.toISOString() + "\n" +
    oldDate.toDateString() +"\n" + oldDate.toUTCString());
    var newDate = oldDate.toDateString().substring(4,10) + ", " + oldDate.toDateString().substring(11,);
    console.log(newDate);
return newDate;
}

function returnbook(e){
    var uTable = document.getElementById('issuedBooks');

      let index = e.parentNode.parentNode.rowIndex;
      var Cells = uTable.rows.item(index).cells;
     let studentRollNo = Cells[0].innerText;
     let  bookName = Cells[1].innerText;
     console.log(index);
     console.log(Cells);
     console.log(studentRollNo);
     console.log(bookName);

     var formDataObject={};
     formDataObject.returnDate= SetreturnDate();
     formDataObject.bookName= bookName;
     formDataObject.studentRollNo=studentRollNo;
     //formDataObject.studentRollNo=
     console.log(formDataObject);
     
     let formDataJsonString = JSON.stringify(formDataObject);
     console.log(formDataJsonString);
      fetch('http://localhost:8080/Library/bookreturn/insert', {
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
           res.then((bookreturn)=>{
             // var d=returnDues();
             // console.log(d);
                 swal(" Returned Successfully!");
               
             })
     
             
           })
     }



  
// form.addEventListener('submit', (e)=>{
//     e.preventDefault();
//     )
   



// }

