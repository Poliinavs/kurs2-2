

import React from 'react';
import PropTypes from 'prop-types';
import '../style/Filter.css';

import row from '../img/Filter/row.png';
import clock from '../img/Filter/clock.png';
import back from '../img/Filter/back.png';
import star from '../img/Filter/star.png';
import jarl from '../img/Filter/jarl.png';
import FilterLink from '../containers/FilterLink';
import FilterText from '../containers/FilterText';
import { VisibilityFilters } from '../actions';

import Button from '@material-ui/core/Button';
import { withStyles } from '@material-ui/core/styles';
import Radio from '@material-ui/core/Radio';
import RadioGroup from '@material-ui/core/RadioGroup';
import FormControlLabel from '@material-ui/core/FormControlLabel';

const ColorButton = withStyles((theme) => ({
button: {
width: '89px',
display: 'flex',
height: '60px',
background: '#0070FB',
borderRadius: '0px 10px 10px 0px',
alignItems: 'center',
justifyContent: 'center',
'&:hover': {
background: '#144179',
},
},
buttonText: {
fontFamily: 'Montserrat',
fontStyle: 'normal',
fontWeight: 700,
fontSize: '14px',
lineHeight: '17px',
display: 'flex',
alignItems: 'center',
color: '#FFFFFF',
},
}))(({ classes, ...props }) => (
<Button className={classes.button} {...props}>
<span className={classes.buttonText}>{props.children}</span>
</Button>
));

const Filter = ({ onClick, liked, name, company, country, data, IsActive, id }) => {
const [selectedOption, setSelectedOption] = React.useState(null);
const [buttonColor, setButtonColor] = React.useState('red');

const handleOptionChange = (event) => {
setSelectedOption(event.target.value);
};

const handleButtonClick = () => {
const newColor = buttonColor === 'red' ? 'blue' : 'red';
setButtonColor(newColor);
};

const [value, setValue] = React.useState('female');

const handleChange = (event) => {
setValue(event.target.value);
};

return (
        <div>
 <div className={'SearchBar'}>
            <form>
                <ul>

                    <li>
                        <a>
                            <img src={row}/>
                            <FilterText  filter={VisibilityFilters.SHOW_City}>
                                </FilterText>
                         
                        </a>
                    </li>

                    <li>
                        <a>
                            <img src={clock}/>
                            <div>График</div>
                        </a>
                 <ul>
                 <RadioGroup
  aria-label="schedule"
  name="schedule"
  value={value}
  onChange={handleChange}
  className='RadioGr'
>
  <FilterLink filter={VisibilityFilters.SHOW_GRAPH1}>
    <FormControlLabel value="FullDay"    control={<Radio color="primary" />} label="Полный день" />
  </FilterLink>
  <FilterLink  filter={VisibilityFilters.SHOW_GRAPH2}>
  <FormControlLabel value="Flexible" control={<Radio color="primary" />} label="Гибкий график" />
  </FilterLink>
  <FilterLink  filter={VisibilityFilters.SHOW_GRAPH3}>
  <FormControlLabel value="Remote" control={<Radio color="primary" />} label="Удалённая работа" />
  </FilterLink>
</RadioGroup>      
                     </ul>
                         
                    </li>

                    <li>
                        <a>
                            <img src={back}/>
                            <div>Занятость</div>
                        </a>
                        <ul>
                        <RadioGroup
                        aria-label="schedule"
  name="schedule"
  value={value}
  onChange={handleChange}
  className='RadioGr'
>
                        <li>
                     
  
    <FilterLink filter={VisibilityFilters.SHOW_Zan1}>
      <FormControlLabel
        value="FullWork"
        control={<Radio color="primary" />}
        label="Полная занятость"
      />
    </FilterLink>
  </li>
  <li>
    <FilterLink filter={VisibilityFilters.SHOW_Zan2}>
      <FormControlLabel
        value="Part-Time"
        control={<Radio color="primary" />}
        label="Частичная занятость"
      />
    </FilterLink>
  </li>
  <li>
    <FilterLink filter={VisibilityFilters.SHOW_Zan3}>
      <FormControlLabel
        value="Project"
        control={<Radio color="primary" />}
        label="Проектная работа"
      />
    </FilterLink>
  </li>
  <li>
    <FilterLink filter={VisibilityFilters.SHOW_Zan4}>
      <FormControlLabel
        value="Intern"
        control={<Radio color="primary" />}
        label="Стажировка"
      />
    </FilterLink>
    
  </li>
  </RadioGroup>
                        </ul>
                        
                    </li>

                    <li>
                        <a>
                            <img src={star}/>
                            <div>Опыт работы</div>
                        </a>
                        <ul>
                        <RadioGroup
                        aria-label="schedule"
  name="schedule"
  value={value}
  onChange={handleChange}
  className='RadioGr'
>
                        <li>
    <FilterLink filter={VisibilityFilters.SHOW_Exper1}>
      <FormControlLabel
        value="no_exp"
        control={<Radio color="primary" />}
        label="Нет опыта"
      />
    </FilterLink>
  </li>
  <li>
    <FilterLink filter={VisibilityFilters.SHOW_Exper2}>
      <FormControlLabel
        value="less_then_3"
        control={<Radio color="primary" />}
        label="От 1 года до 3 лет"
      />
    </FilterLink>
  </li>
  <li>
    <FilterLink filter={VisibilityFilters.SHOW_Exper3}>
      <FormControlLabel
        value="less_then_6"
        control={<Radio color="primary" />}
        label="От 3 до 6 лет"
      />
    </FilterLink>
  </li>
  <li>
    <FilterLink filter={VisibilityFilters.SHOW_Exper4}>
      <FormControlLabel
        value="more_then_6"
        control={<Radio color="primary" />}
        label="Более 6 лет"
      />
    </FilterLink>
  </li>
                  </RadioGroup>          
                        </ul>
                    </li>

                    <li>
                        <a>
                            <img src={jarl}/>
                            <FilterText  filter={VisibilityFilters.SHOW_Price}>
                                </FilterText>
                            {/* <input type='text'/> */}
                        </a>
                    </li>
                    <ColorButton>
       Поиск
      </ColorButton>
                    {/* <Button variant="contained" color="primary" className={classes.button}>
      <p className={classes.buttonText}>Primary</p>
    </Button> */}

                    {/* <button className={'Find'}>Поиск</button> */}
                    </ul>
                    </form>
                    </div>


                    <div className={'SearchBar1'}>
            <form>
                <ul>

                    <li>
                        <a>
                            <img src={row}/>
                            <FilterText  filter={VisibilityFilters.SHOW_City}>
                                </FilterText>
                            {/* <input type='text'/> */}
                        </a>
                    </li>

                   

                 

                    <li>
                        <a>
                            <img src={jarl}/>
                            <FilterText  filter={VisibilityFilters.SHOW_Price}>
                                </FilterText>
                            {/* <input type='text'/> */}
                        </a>
                    </li>
                    <li>
                        <a>
                            <div>Фильтр</div>
                        </a>
                        <ul>
                           
                            <li>
                            <label className='NameTitle' htmlFor="option1">
                             
                      График
                                </label>
                            <FilterLink  filter={VisibilityFilters.SHOW_GRAPH1}>
                                <input type="radio" id="schedule" name="schedule" value="FullDay"/>
                                <label htmlFor="option1">
                             
                                Полный день
                                   </label>
                                   </FilterLink>
                             </li>
                            <li>
                            <FilterLink  filter={VisibilityFilters.SHOW_GRAPH2}>
                                <input type="radio" id="schedule" name="schedule" value="Flexible"/>
                                <label htmlFor="option2">Гибкий график</label>
                                </FilterLink>
                            </li>
                            <li>
                            <FilterLink  filter={VisibilityFilters.SHOW_GRAPH3}>
                                <input type="radio" id="schedule" name="schedule" value="Remote"/>
                                <label htmlFor="option3">Удалённая работа</label>
                                </FilterLink>
                            </li>
                            <li>
                            <label className='NameTitle' htmlFor="option1">
                            Занятость</label>
                            </li>
                            <li>
                            <FilterLink  filter={VisibilityFilters.SHOW_Zan1}>
                                <input type="radio" id="option3" name="Time" value="FullWork"частичная занятость/>
                              
                                <label htmlFor="option1">Полная занятость</label>
                              </FilterLink>
                               
                            </li>
                            <li>
                            <FilterLink  filter={VisibilityFilters.SHOW_Zan2}>
                                <input type="radio" id="option3" name="Time" value="Part-Time"/>
                                <label htmlFor="option2">Частичная занятость</label>
                            </FilterLink>
                            </li>
                            <li>
                            <FilterLink  filter={VisibilityFilters.SHOW_Zan3}>
                                <input type="radio" id="option3" name="Time" value="Project"/>
                                <label htmlFor="option3">Проектная работа</label>
                                </FilterLink>
                            </li>
                            <li>
                            <FilterLink  filter={VisibilityFilters.SHOW_Zan4}>
                                <input type="radio" id="option3" name="Time" value="Intern"/>
                                <label htmlFor="option4">Стажировка</label>
                                </FilterLink>
                            </li>

                            <li>
                            <label className='NameTitle' htmlFor="option1">
                            Опыт работы</label>
                            </li>
                            <li>
                            <FilterLink  filter={VisibilityFilters.SHOW_Exper1}>
                                <input type="radio" id="option4" name="Experience" value="no_exp"/>
                                <label htmlFor="option1">Нет опыта</label>
                                </FilterLink>
                            </li>
                            <li>
                            <FilterLink  filter={VisibilityFilters.SHOW_Exper2}>
                                <input type="radio" id="option4" name="Experience" value="less_then_3"/>
                                <label htmlFor="option2">От 1 года до 3 лет</label>
                                </FilterLink>
                            </li>
                            <li>
                            <FilterLink  filter={VisibilityFilters.SHOW_Exper3}>
                                <input type="radio" id="option4" name="Experience" value="less_then_6"/>
                                <label htmlFor="option3">От 3 до 6 лет</label>
                                </FilterLink>
                            </li>
                            <li>
                            <FilterLink  filter={VisibilityFilters.SHOW_Exper4}>
                                <input type="radio" id="option4" name="Experience" value="more_then_6"/>
                                <label htmlFor="option4">Более 6 лет</label>
                                </FilterLink>
                            </li>
                            


                        </ul>
                    </li>

                    <ColorButton>
       Поиск
      </ColorButton>
                    </ul>
                    </form>
                    </div>

                    
                    <div className={'SearchBar2'}>
            <form>
                <ul>

                    <li>
                        <a>
                            <img src={row}/>
                            <FilterText  filter={VisibilityFilters.SHOW_City}>
                                </FilterText>
                            {/* <input type='text'/> */}
                        </a>
                    </li>

                   

                 

                    
                    <li>
                        <a>
                            <div>Фильтр</div>
                        </a>
                        <ul>
                        <li>
                        <a>
                            <img src={jarl}/>
                            <FilterText  filter={VisibilityFilters.SHOW_Price}>
                                </FilterText>
                            {/* <input type='text'/> */}
                        </a>
                    </li>
                           
                            <li>
                            <label className='NameTitle' htmlFor="option1">
                             
                      График
                                </label>
                            <FilterLink  filter={VisibilityFilters.SHOW_GRAPH1}>
                                <input type="radio" id="schedule" name="schedule" value="FullDay"/>
                                <label htmlFor="option1">
                             
                                Полный день
                                   </label>
                                   </FilterLink>
                             </li>
                            <li>
                            <FilterLink  filter={VisibilityFilters.SHOW_GRAPH2}>
                                <input type="radio" id="schedule" name="schedule" value="Flexible"/>
                                <label htmlFor="option2">Гибкий график</label>
                                </FilterLink>
                            </li>
                            <li>
                            <FilterLink  filter={VisibilityFilters.SHOW_GRAPH3}>
                                <input type="radio" id="schedule" name="schedule" value="Remote"/>
                                <label htmlFor="option3">Удалённая работа</label>
                                </FilterLink>
                            </li>
                            <li>
                            <label className='NameTitle' htmlFor="option1">
                            Занятость</label>
                            </li>
                            <li>
                            <FilterLink  filter={VisibilityFilters.SHOW_Zan1}>
                                <input type="radio" id="option3" name="Time" value="FullWork"частичная занятость/>
                              
                                <label htmlFor="option1">Полная занятость</label>
                              </FilterLink>
                               
                            </li>
                            <li>
                            <FilterLink  filter={VisibilityFilters.SHOW_Zan2}>
                                <input type="radio" id="option3" name="Time" value="Part-Time"/>
                                <label htmlFor="option2">Частичная занятость</label>
                            </FilterLink>
                            </li>
                            <li>
                            <FilterLink  filter={VisibilityFilters.SHOW_Zan3}>
                                <input type="radio" id="option3" name="Time" value="Project"/>
                                <label htmlFor="option3">Проектная работа</label>
                                </FilterLink>
                            </li>
                            <li>
                            <FilterLink  filter={VisibilityFilters.SHOW_Zan4}>
                                <input type="radio" id="option3" name="Time" value="Intern"/>
                                <label htmlFor="option4">Стажировка</label>
                                </FilterLink>
                            </li>

                            <li>
                            <label className='NameTitle' htmlFor="option1">
                            Опыт работы</label>
                            </li>
                            <li>
                            <FilterLink  filter={VisibilityFilters.SHOW_Exper1}>
                                <input type="radio" id="option4" name="Experience" value="no_exp"/>
                                <label htmlFor="option1">Нет опыта</label>
                                </FilterLink>
                            </li>
                            <li>
                            <FilterLink  filter={VisibilityFilters.SHOW_Exper2}>
                                <input type="radio" id="option4" name="Experience" value="less_then_3"/>
                                <label htmlFor="option2">От 1 года до 3 лет</label>
                                </FilterLink>
                            </li>
                            <li>
                            <FilterLink  filter={VisibilityFilters.SHOW_Exper3}>
                                <input type="radio" id="option4" name="Experience" value="less_then_6"/>
                                <label htmlFor="option3">От 3 до 6 лет</label>
                                </FilterLink>
                            </li>
                            <li>
                            <FilterLink  filter={VisibilityFilters.SHOW_Exper4}>
                                <input type="radio" id="option4" name="Experience" value="more_then_6"/>
                                <label htmlFor="option4">Более 6 лет</label>
                                </FilterLink>
                            </li>
                            


                        </ul>
                    </li>

                    <ColorButton>
       Поиск
      </ColorButton>
                    </ul>
                    </form>
                    </div>
       
      
</div>

);
};



export default Filter
