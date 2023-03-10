

// const  Enteredbookname= Enteredbookname.value;

// console.log( Enteredbookname);



let suggestions = [];
fetch('http://localhost:8080/LibraryManagementProject/books')
.then((response)=> response.json())
    .then((json)=>{
        json.forEach(book => {
            console.log(book.bookName)
            suggestions.push(book.bookName);
        });
    })


// getting all required elements
const searchWrapper = document.querySelector(".search-input");
const inputBox = searchWrapper.querySelector("input");
const suggBox = searchWrapper.querySelector(".autocom-box");
// const icon = searchWrapper.querySelector(".icon");
let linkTag = searchWrapper.querySelector("a");
let webLink;

// if user press any key and release
inputBox.onkeyup = (e)=>{
    let userData = e.target.value; //user entered data
    let emptyArray = [];
    if(userData){
        // icon.onclick = ()=>{
        //     webLink = `https://www.google.com/search?q=${userData}`;
        //     linkTag.setAttribute("href", webLink);
        //     linkTag.click();
        //     console.log(userData);
        // }
        emptyArray = suggestions.filter((data)=>{
            //filtering array value and user characters to lowercase and return only those words which are start with user entered chars
            return data.toLocaleLowerCase().startsWith(userData.toLocaleLowerCase());
        });
        emptyArray = emptyArray.map((data)=>{
            // passing return data inside li tag
            return data = `<li>${data}</li>`;
        });
        searchWrapper.classList.add("active"); //show autocomplete box
        showSuggestions(emptyArray);
        let allList = suggBox.querySelectorAll("li");
        for (let i = 0; i < allList.length; i++) {
            //adding onclick attribute in all li tag
            allList[i].setAttribute("onclick", "select(this)");
            console.log(allList[i]);
            console.log(allList[i].value);
            var bookName=inputBox.value;
            console.log(bookName);
           
        }
    }else{
        searchWrapper.classList.remove("active"); //hide autocomplete box
    }
}



function issueBook(){
   
    const formData = new FormData(form);
    const form = document.getElementById('issue');
    let formDataObject = Object.fromEntries(formData.entries());
      // Format the plain form data as JSON
      let formDataJsonString = JSON.stringify(formDataObject);
      console.log(formDataJsonString);
           
           const bookName = document.getElementById('bookname');
           console.log('bookName');
}

function select(element){
    let selectData = element.textContent;
    inputBox.value = selectData;
    icon.onclick = ()=>{
        webLink = `https://www.google.com/search?q=${selectData}`;
        linkTag.setAttribute("href", webLink);
        linkTag.click();
    }
    searchWrapper.classList.remove("active");
}

function showSuggestions(list){
    let listData;
    if(!list.length){
        userValue = inputBox.value;
        listData = `<li>${userValue}</li>`;
    }else{
      listData = list.join('');
    }
    suggBox.innerHTML = listData;
}

  
const form = document.getElementById('issue');
  
form.addEventListener('submit', (e)=>{
    e.preventDefault();

    const formData = new FormData(form);
    // const data = new URLSearchParams(formData);
     //Create an object from the form data entries
 

  let formDataObject = Object.fromEntries(formData.entries());
  for(field in formDataObject ){
    if(!field.value){
      alert(field+" cannot be empty");
    }
   }
  console.log(formDataObject.issueDate);
    //changing date format
    var oldDate = new Date(formDataObject.issueDate);
    console.log( oldDate.toLocaleDateString() + "\n" + oldDate.toISOString() + "\n" +
    oldDate.toDateString() +"\n" + oldDate.toUTCString());
    var newDate = oldDate.toDateString().substring(4,10) + ", " + oldDate.toDateString().substring(11,);
    console.log(newDate);
    formDataObject.issueDate=newDate;
    // Format the plain form data as JSON
    let formDataJsonString = JSON.stringify(formDataObject);

    console.log(formDataJsonString);
    fetch('http://localhost:8080/LibraryManagementProject/userandbook/insert', {
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
        res.then((bookissue)=>{
            
            alert(" Issued Successfully!");
          
        })
      })
});

