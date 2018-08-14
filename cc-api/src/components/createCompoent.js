import React, { Component } from 'react';
import '../styles/markdown.css';
import SimpleMDE from 'simplemde'
import marked from 'marked'
import highlight from 'highlight.js'
// import Utils from '../util/util';

import 'simplemde/dist/simplemde.min.css';
import '../styles/font-awesome/css/font-awesome.css';

export default class createCompoent extends Component {
    constructor() {
        super();
        this.state = {
            previewContent: null,
            previewContentHtml: null,
            smde: null
        };
    }

    componentDidMount() {
        this.state.smde = new SimpleMDE({
            element: document.getElementById('editor').childElementCount,
            autoDownloadFontAwesome: false,
            status: false,
            autofocus: true,
            autosave: true,
            previewRender: function (plainText) {
                return marked(plainText, {
                    renderer: new marked.Renderer(),
                    gfm: true,
                    pedantic: false,
                    sanitize: false,
                    tables: true,
                    breaks: true,
                    smartLists: true,
                    smartypants: true,
                    highlight: function (code) {
                        return highlight.highlightAuto(code).value;
                    }
                });
            },
        });

        this.state.smde.value('![Yes](https://i.imgur.com/sZlktY7.png)');
    }

    onContentChange(e) {
        let values = this.state.smde.value(), htmls;
        if (values) {
            htmls = marked.parse(values);
        }
        this.setState({
            previewContent: values,
            previewContentHtml: htmls
        }, () => { });

    }

    render() {
        return (
            <div>
                createCompoent
            < br />
                {/* <div id="editor" contentEditable="plaintext-only" onInput={() => {
                    this.onContentChange.bind(this);
                }}></div> */}
                <textarea id="editor"></textarea>

                <button
                    onClick={(e) => {
                        this.onContentChange();
                    }}
                >
                    获取数据
                </button>
                <div>
                    {this.state.previewContent}
                </div>
                <div dangerouslySetInnerHTML={{ __html: this.state.previewContentHtml }}></div>
            </div >
        );
    }
}