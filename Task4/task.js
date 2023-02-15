var todoitems=[{Activity:"Exercise",status:0},
{Activity:"Breakfast",status:0},
{Activity:"Meet a friend",status:0},
{Activity:"Nothing",status:0}]
//var task_done=0;
//var task_remained=0;

display();
function display(){
   const len=todoitems.length;
   var u = document.getElementsByTagName('ul')[0];
   var u1 = document.createElement('ul');
   u.replaceWith(u1);
   for(let i = 0; i < todoitems.length; i++){
      const c=document.createElement("li");
      c.setAttribute("class", "forcolor");
      c.textContent=todoitems[i].Activity;
      const y = document.createElement("INPUT");
         y.setAttribute("type", "checkbox");
         y.setAttribute("class", "Checkif");
         u1.appendChild(c);
         c.append(y);
      
}


tocolor();

}
function tocolor(){
   var newcheck= document.getElementsByClassName('Checkif');
   var lenofcheck=newcheck.length;
console.log(lenofcheck);
console.log(newcheck);
for (let j = 0; j < lenofcheck; j++) {
  console.log(newcheck[j]);
  newcheck[j].addEventListener('click',function(){
     console.log('done');
     console.log(newcheck[j].parentElement);
     newcheck[j].parentElement.classList.toggle('forgreencolor');
     
     
    // if(newcheck[j].parentElement.style.color=="green"){
      //task_done=task_done+1;
    // }
     
  })
}
tofind();
}

  function addlist(){
   let a= newtask.value;
   todoitems.push({Activity:a,status:0});
   newtask.value="";
   display();
   
}

function tofind(){
   var e=todoitems.length;
 //task_remained=e-(task_done);
 document.getElementById("Notask").innerHTML=e;
 //document.getElementById("Fordone").innerHTML=task_done;
 //document.getElementById("Remained").innerHTML=task_remained;
}

   //var index;
   /*var newcheck= document.getElementsByClassName('Checkif');
   var lenofcheck=newcheck.length;
   console.log(lenofcheck);
   console.log(newcheck);
   for (let i = 0; i < lenofcheck; i++) {
      console.log(newcheck[i]);

      if(newcheck[i].checked==true){

         newcheck.parentElement.style.color="red";
      }
  }
   
   //var ul = document.getElementsByTagName('li')[0];
   //console.log(ul);

   //newcheck.addEventListener('click', function(e) {
   //console.log(e.target.tagName);
   /*if (e.target.tagName === 'INPUT') {

      var listt= e.target.parentNode;
      console.log(listt);
      var nodes = Array.from( listt.closest('ul').children);
      index = nodes.indexOf(e.target.closest('li'));
      //console.log(nodes);
      //console.log(index);

      //list.parentElement.style.color=red;
         /*var li = e.target.closest('li');
      
   
      
      var checkBox  = document.getElementsByClassName('Checkif')[index];
      
      if(checkBox.checked===true){
      checkBox.checked=false;
      list.classList.remove('colored');
      }else{
      checkBox.checked=true;
      list.classList.add('colored');
      }
      
      if(todoitems[index].status===0){
      todoitems[index].status=1;
      }else{
      todoitems[index].status=0;
      }
      console.log(todoitems);*/
   
   


 



