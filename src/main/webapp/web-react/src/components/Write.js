import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import Editor from 'tui-editor';

class Write extends Component {
    constructor(props) {
        super(props);

        var editor = new Editor({
            el: document.querySelector('#editSection'),
            initialEditType: 'markdown',
            previewStyle: 'vertical',
            height: '300px'
        });
    }

    render() {
        return (
            <div>
            </div>
        );
    }
}

export default Write;