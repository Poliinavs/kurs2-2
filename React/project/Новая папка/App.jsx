import React from 'react';
import  './style/App.css';
import Menu from "./Menu-telephone/MenuTelephone"


const App=() =>{

  // по умолчанию меню не видно
const [menuActive, setMenuActive]=  React.useState(false);

  const items = [{value:"Поиск вакансий", href: '/main'},
                {value:"Избранные вакансии", href: '/choose'}
                 ]
 // const items = [{value:"Поиск вакансий", href: '/main', icon:'dd'}]


  return (
    <div className='app'>
    <nav>
      {/* передаем параметром обратное значение открытости закрытости меню */}
        <div className='burger-btn' onClick={()=>setMenuActive(!menuActive)}>
            <span/>
        </div>
    </nav>
    <main>
        <p>dddddddddddddddddddddddddddddddddddddddddddddddd</p>
        <p>dddddddddddddddddddddddddddddddddddddddddddddddd</p>
        <p>dddddddddddddddddddddddddddddddddddddddddddddddd</p>
    </main>

   
    <Menu active={menuActive} setActive={setMenuActive} header={"FrontendJob"} items={items}/>
  
   </div>


  );

};
export default App;