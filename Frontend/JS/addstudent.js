  
  const form = document.getElementById('addstudent');
  
  form.addEventListener('submit', (e)=>{
      e.preventDefault();
  
      const formData = new FormData(form);
      // const data = new URLSearchParams(formData);
       //Create an object from the form data entries
    let formDataObject = Object.fromEntries(formData.entries());
      // Format the plain form data as JSON

      for(field in formDataObject ){
        if(!field.value){
          alert(field+" cannot be empty");
        }
       }
      let formDataJsonString = JSON.stringify(formDataObject);
  
      console.log(formDataJsonString);
      fetch('http://localhost:8080/LibraryManagementProject/students/insert', {
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
              alert(student.studentName +" Added Successfully!");
            //   if(book.Name != 0){
            //       // alert("succesfully logged in")
            //       window.location.href = "overview.html"
            //   }else{
            //       alert("Wrong credentials")
            //   }
          })
        })
  });