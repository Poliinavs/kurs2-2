import React from 'react'
import  '../style/Menu.css';

import Menu from './menu'
import logo from '../img/Menu/FRONT.png'
import burger from '../img/Menu/Burger.png'
import close from '../img/Menu/close.png'

import FilterLink from '../containers/FilterLink'
import { VisibilityFilters } from '../actions'


const MainMenu=() =>{
  // по умолчанию меню не видно
  const [menuActive, setMenuActive]=  React.useState(false);

  const items = [{value:"Поиск вакансий", href: '/main'},
                {value:"Избранные вакансии", href: '/choose'}
                 ]
                 const [imagePath, setImagePath] = React.useState(burger);
               
                 const handleClick = () => {
                   setMenuActive(!menuActive);
                   if (imagePath === burger) {
                    setImagePath(close);
                  } else {
                    setImagePath(burger);
                  }
                  
                 };

  return (
      <div>
            <header className='OsnMenu'>
         <img src={logo} alt="Логотип" />
  
         <FilterLink className="Menu"  filter={VisibilityFilters.SHOW_ALL}>
         Поиск вакансий
    </FilterLink>
    <div className="Link1">
    <FilterLink  filter={VisibilityFilters.SHOW_Like}>
         Избранные вакансии
    </FilterLink>
    </div>
   
 
   
   
  </header>


    <div  onClick={handleClick}  className='menuMobile'>
    <img className="left-image" src={logo}  alt="Логотип" />


    <img className="right-image"  src={imagePath} onClick={handleClick}  alt="Логотип" />

    <Menu active={menuActive} setActive={setMenuActive} items={items}/>
   </div>



      </div>
  


  );

};

export default MainMenu