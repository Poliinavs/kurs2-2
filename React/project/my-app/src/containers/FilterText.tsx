import { connect } from 'react-redux';
import { setVisibilityFilter } from '../actions';
import Text from '../components/Text';
import { setLenguage, getLenguage } from './VisibleJobList';

import { Dispatch } from 'redux';



interface StateProps {
  active: boolean;
}


const mapStateToProps = (state: any, ownProps: any): StateProps => ({
  active: ownProps.filter === state.visibilityFilter,
});

const mapDispatchToProps = (dispatch: Dispatch, ownProps: any) => ({
  onChange: (e: any) => {
    const newValue = e.target.value;
    const jsVariable = newValue;
  
    setLenguage(newValue);
  
    dispatch(setVisibilityFilter(ownProps.filter));
  },
});

const Container = connect<StateProps>(
  mapStateToProps,
  mapDispatchToProps
)(Text);

export default Container;