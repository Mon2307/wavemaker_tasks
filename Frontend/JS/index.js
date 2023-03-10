
  
  const form = document.getElementById('addBook');
  
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
      // Format the plain form data as JSON
      let formDataJsonString = JSON.stringify(formDataObject);

  
      console.log(formDataJsonString);
      fetch('http://localhost:8080/LibraryManagementProject/books/insert', {
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
              console.log(book.Name);
              alert(book.Name + "Added Successfully!")
           
          })
        })
  });













  // const addBookForm = document.getElementById("addBook");

// addBookForm.addEventListener("submit", handleFormSubmit);

// async function handleFormSubmit(event){
//     event.preventDefault();
//     const form = event.currentTarget;
//     // const url = form.action;

//     try{
//         // This takes all the fields in the form and makes their values  available through a `FormData` instance.
//         const formData= new FormData(form);
//         const url="http://localhost:8080/LibraryManagementProject/books/insert";

//         const responseData = await postFormDataAsJson({ url, formData });
//         console.log({ responseData });

//     }
//     catch (error) {
// 		console.error("Something went wrong!");
// }
// }


// async function postFormDataAsJson({url, formData}){
//     const plainFormData = Object.fromEntries(formData.entries());
// 	const formDataJsonString = JSON.stringify(plainFormData);

//     const fetchOptions={
//         method: "POST",
// 		headers: {
// 			"Content-Type": "application/json",
// 			Accept: "application/json",
// 		},
// 		body: formDataJsonString
//     };

//     const response = await fetch(url, fetchOptions);
//     if (!response.ok) {
// 		const errorMessage = await response.text();
// 		throw new Error(errorMessage);
// 	}
     
// 	return response.json();

// }

