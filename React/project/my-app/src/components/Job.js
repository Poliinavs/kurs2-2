
import React from 'react'
import PropTypes from 'prop-types'
import  '../style/MainInform.css'
import  '../style/Job.css'
import FilterLink from '../containers/FilterLink'
import { VisibilityFilters } from '../actions'


import fr from '../img/List/Fr.png'

import tree from '../img/List/Three.png'
import like from '../img/List/like.png'
import dislike from '../img/List/Dislike.png'
const images = [
  { path: require('../img/List/React.png'), strings: ["jQuery", "JavaScript", "CSS3","React", "Vue", "Flexbox"] },
  { path: require('../img/List/Fr.png'), strings: ["jQuery", "JavaScript", "CSS3", "React", "Vue"] },
  { path: require('../img/List/Three.png'), strings: ["jQuery", "JavaScript"] },
  { path: require('../img/List/Foth.png'), strings: ["jQuery", "JavaScript", "CSS3","React", "Vue", "Flexbox"] }
];
 
 


//для 1 работы передавать объект с полями вместо текст
// const Todo = ({ onClick, completed, text }) => (

//Стиль для 1 жлемента из MainInform в отдельный


const Job = ({ onClick, BlockClick, liked,name , company, country,data, IsActive, id} ) => {
  // const [isActive, setIsActive] = React.useState(false);
 
  
  
    const highlight = (IsActive) => {
      
      IsActive=!IsActive;
    };

  
  
    return (
      <div onClick={BlockClick} className={`List ${IsActive ? 'active' : ''}`} >
    
    <img class="image" src={images[id-1].path} alt="Картинка" />
           <div class="elements">
           <div className='firstRow'> 
           <p className='SmallText'>{name}</p>
           <img   onClick={onClick} class="image" src={liked ? like : dislike} alt="Картинка" />
           </div>
           <p className='NameComp'>{company}</p>
           <p className='SmallText'>{country}</p>
           <div className='LastRow'>
           <div className='Tag'>
           {images[id-1].strings.map((tag, index) => (
              <div className='TagInform' key={index}>
                 <FilterLink filter={VisibilityFilters.SHOW_React}>
                   
                           {tag}
                  </FilterLink>
               
              </div>
            ))}
              

             </div>
             <p className='data'>{data}</p>
           </div>
            
           </div>
          


       </div>

//   <li
//     onClick={onClick}
//     style={{
//       textDecoration: completed ? 'line-through' : 'none'
//     }}
//   >
//     {/* {text} */}
//   </li>
);
};

// Todo.propTypes = {
//   onClick: PropTypes.func.isRequired,
//   completed: PropTypes.bool.isRequired,
//   text: PropTypes.string.isRequired
// }

export default Job
