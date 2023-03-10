  
  function loginpage(){
    window.location.href="index.html";
  }
  
  
  
  const form = document.getElementById('signupForm');
  
  form.addEventListener('submit', (e)=>{
      e.preventDefault();
  
      const formData = new FormData(form);
      // const data = new URLSearchParams(formData);
       //Create an object from the form data entries
       console.log(formData);
    let formDataObject = Object.fromEntries(formData.entries());
    console.log(formDataObject);
    // formDataObject.forEach(field => {
    //   if(!field.value){
    //     alert(field +"cannot be empty");
    //   }
    // });
         for(field in formDataObject ){
          if(!field.value){
            alert(field+" cannot be empty");
          }
         }
    console.log(formDataObject.joiningDate);
      //changing date format
      var oldDate = new Date(formDataObject.joiningDate);
      console.log( oldDate.toLocaleDateString() + "\n" + oldDate.toISOString() + "\n" +
      oldDate.toDateString() +"\n" + oldDate.toUTCString());
      var newDate = oldDate.toDateString().substring(4,10) + ", " + oldDate.toDateString().substring(11,);
      console.log(newDate);
      formDataObject.joiningDate=newDate;
          // Format the plain form data as JSON
        let formDataJsonString = JSON.stringify(formDataObject);
        console.log(formDataJsonString);
      fetch('http://localhost:8080/LibraryManagementProject/librarians/insert', {
        method: 'POST',
        headers: {
            "Content-Type": "application/json",
            Accept: "application/json",
            mode:'no-cors',
          },
          body: formDataJsonString
      }).then((response) => {
          
          if(!response.ok) {
            throw response;
          }
      
         
          const res = response.json();
           console.log(res);
        //   console.log('Done');
          res.then((librarian)=>{
              console.log(librarian.librarianName);
              alert(librarian.librarianName +" Added Successfully!");
            
          })
        })
  });