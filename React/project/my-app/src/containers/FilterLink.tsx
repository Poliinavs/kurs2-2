import { connect } from 'react-redux';
import { setVisibilityFilter } from '../actions';
import Link from '../components/Link';
import { setLenguage, getLenguage } from './VisibleJobList';

import { Dispatch } from 'redux';



interface StateProps {
  active: boolean;
}

interface DispatchProps {
  onClick: () => void;
}

const mapStateToProps = (state: any, ownProps: any): StateProps => ({
  active: ownProps.filter === state.visibilityFilter,
});

const mapDispatchToProps = (dispatch: Dispatch, ownProps: any): DispatchProps => ({
  onClick: () => {
    setLenguage(ownProps.children);

    dispatch(setVisibilityFilter(ownProps.filter));

    console.log(ownProps.children);
    // Дополнительные действия при нажатии на ссылку
    // ...
  },
});

const Container = connect<StateProps, DispatchProps>(
  mapStateToProps,
  mapDispatchToProps
)(Link);

export default Container;
