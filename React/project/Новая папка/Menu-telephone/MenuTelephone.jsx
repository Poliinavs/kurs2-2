import React from 'react';

import './Menu.css'

const Menu=({header, items, active, setActive}) =>{
  return (
    <div className={active? 'menu active':'menu' }>
        <div className='blur'/>
        <div className='menu_cont'>
            <div className='menu_header'>{header}</div>
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