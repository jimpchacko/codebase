import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Person from './Person/Person';


class App extends Component {
	
state = {
persons:

[
{name : 'your great greate ...grandfather', age: 999},

{name : 'your great greate ...grandmother', age: 992},
{name : 'your great greate ...grandfather', age: 999}
],
otherState: 'some other value'
}

switchNameHandler=(newName)=>{
console.log('clicked')
this.setState({
persons:[
{name:'you', age:22},

{name:'jim', age:17},
{name:'hari', age:22}
]


})
}

nameChangeHandler=(event)=>{

this.setState(
{

persons:[
{name:'Jim', age:17},
{name:event.target.value,age:27},
{name:'jobs',age:26}

]

}

)
}

render()  {
	const style ={

	backGroundColor:'white',
	font : 'inherit'	,
	border:'1px solid blue',
	cursor:'pointer'
};	

return (


	<div className = "App">
	<h1>I am react app</h1>
	<p>This is a miracle</p>
	<button style={style}
	onClick={()=>this.switchNameHandler('Maxffdhfgh!!!!')}>Switch Name
</button>
<Person name = {this.state.persons[0].name} age = {this.state.persons[0].age}/>
<Person name = {this.state.persons[1].name} age = {this.state.persons[1].age} click={this.switchNameHandler.bind(this,'Naruto')}
changed = {this.nameChangeHandler}>My hobbies: racing</Person>
<Person name = {this.state.persons[2].name} age = {this.state.persons[2].age}/>
	</div>





);
  }
}
export default App;
