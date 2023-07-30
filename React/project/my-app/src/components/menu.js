import React from 'react';

import '../style/Menu.css'
//Это похожн на TodoList 
//в этом файле отрисуем видимое меню и кнопку при нажатии на которую
//будет изменятьься видимость(вызывается генератор)
//и прокидывается открывающ меню с выпадающим списком и в параметр вилимость
//TodoList



const Menu=({header, items, active, setActive}) =>{
  return (
    <div className={active? 'menu active':'menu' }>
        <div className='blur'/>
        <div className='menu_cont'>
           
            <ul>
                {items.map(
                    item => <li>
                        <a href={item.href}> {item.value} </a>
                    </li>
                )

                }
            </ul>
        </div>
  
   </div>


  );

};
export default Menu;