import React, { Component } from 'react';
import { Form, Input, Button, BackTop } from 'antd';
import { message } from 'antd';
import SimpleMDE from 'simplemde'
import marked from 'marked'
import highlight from 'highlight.js'
import Utils from '../util/util';

import '../styles/font-awesome/css/font-awesome.css';
import 'simplemde/dist/simplemde.min.css';
// import 'highlight.js/styles/default.css';
import 'highlight.js/styles/github.css';
import '../styles/markdown.css';
import { post } from '../util/xhr';

const FormItem = Form.Item;

/**
 * 创建文档
 */
export default class createCompoent extends Component {
    constructor() {
        super();
        this.state = {
            test: true,
            formLayout: 'horizontal',// 'vertical'
            previewTitle: null,
            previewContent: null,
            previewContentHtml: null,
            smde: null
        };
    }

    componentDidMount() {
        const urlParams = Utils.urlSearchParams();
        console.log(urlParams);
        this.createSimpleEditor();
        post('//127.0.0.1:8091/apis/article/getArticleLists', { BusID: '123456' }).then(res => {
            console.log(res);
        }).catch(e => {
            console.log(e);
        });
    }

    createSimpleEditor(backContent) {
        const self = this;
        const editor = new SimpleMDE({
            element: document.getElementById('editor').childElementCount,
            autoDownloadFontAwesome: false,
            status: false,
            autofocus: true,
            autosave: true,
            forceSync: true,
            previewRender: function (plainText) {
                const value = marked(plainText, {
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
                return value;
            }
        });

        this.setState({ smde: editor }, () => {
            if (this.state.test) {
                this.state.smde.value('![Yes](https://i.imgur.com/sZlktY7.png) \n```js \n function actions(){} ```');
                this.onContentChange();
            }

            this.state.smde.codemirror.on("change", function () {
                setTimeout(function () {
                    self.onContentChange();
                }, 500);
            });
        });
    }

    onContentChange(e) {
        let values = this.state.smde.value(), htmls;
        if (values) {
            // htmls = marked.parse(values);
            htmls = marked(values, {
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
        }
        this.setState({ previewContent: values, previewContentHtml: htmls }, () => { });

    }

    submitSaveArticle() {
        let params = {
            articleTitle: this.state.previewTitle,
            articleContent: this.state.previewContent,
            articleContentHtml: this.state.previewContentHtml
        }
        if (!params.articleTitle) {
            return message.warning('文章标题不能为空', 2);
        }
        if (!params.articleContent) {
            return message.warning('文章内容不能为空', 2);
        }

        console.log(params);

    }

    render() {
        return (
            <div className="body-content">
                <Form layout={this.state.formLayout}>
                    <FormItem label="文章标题" >
                        <Input placeholder="请输入文章标题，限50字内" value={this.state.previewTitle} />
                    </FormItem>
                    <FormItem label="文章内容" >
                        <div className="view-content">
                            <div className="editor-content">
                                <textarea id="editor"></textarea>
                            </div>
                            <div className="preview-content">
                                {/* <div>{this.state.previewContent}</div> */}
                                <div dangerouslySetInnerHTML={{ __html: this.state.previewContentHtml }}></div>
                            </div>
                        </div>
                    </FormItem>
                    <FormItem >
                        <Button type="primary" onClick={(e) => { this.submitSaveArticle(); }}>Submit</Button>
                    </FormItem>
                </Form>

                <BackTop style={{ bottom: "80px" }} visibilityHeight={200} onClick={() => { console.log('visibilityHeight:300'); }} />
            </div >
        );
    }
}