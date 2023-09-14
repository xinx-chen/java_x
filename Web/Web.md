# Web

## 文件处理

**关于大小写和空格**

你会注意到，在这篇文章中，我们要求你完全用小写字母命名文件夹和文件，没有空格。这是因为：

1. 许多计算机，特别是网络服务器，是区分大小写的。因此，假如你把一张图片放在你的网站上 `test-site/MyImage.jpg`，然后在一个不同的文件中，你试图以 `test-site/myimage.jpg` 来调用该图片，它可能无法工作。

2. 浏览器、网络服务器和编程语言对空格的处理并不一致。例如，如果你在文件名中使用空格，一些系统可能将其视为两个文件名。一些服务器会用“%20”（URL 中空格的字符代码）替换文件名中的区域，导致所有链接被破坏。最好用连字符而不是下划线来分隔单词。对比 `my-file.html` 与 `my_file.html`。

   简言之，文件名中应使用连字符。谷歌搜索引擎把连字符当作单词的分隔符，但不会识别下划线。基于此，最好在一开始就养成习惯，文件夹和文件名使用小写，用短横线来分隔。这可以避免许多问题。

##网站应该用什么结构？

接下来，让我们看看我们的测试网站应该是什么结构。在我们创建的任何网站项目中，最常见的是一个主页 HTML 文件和包含图像、样式文件和脚本文件的文件夹。现在让我们来创建这些：

1. **`index.html`**：这个文件一般会包含主页内容，也就是人们第一次进入网站时看到的文字和图片。使用文本编辑器，创建一个名为`index.html`的新文件，并将其保存在`test-site`文件夹内。
2. **`images` 文件夹**：这个文件夹包含网站上使用的所有图片。在 `test-site` 文件夹内创建一个名为 `images` 的文件夹。
3. **`styles` 文件夹**：这个文件夹包含用于设置内容样式的 CSS 代码（例如，设置文本和背景颜色）。在你的 `test-site` 文件夹内创建一个名为 `styles` 的文件夹。
4. **`scripts` 文件夹**：这个文件夹包含所有用于向网站添加交互功能的 JavaScript 代码（例如，点击时加载数据的按钮）。在 `test-site` 文件夹内创建一个名为 `scripts` 的文件夹。

**备注：** 在 Windows 上你可能看不到文件扩展名，因为 Windows 有一个默认开启的**隐藏已知文件类型的扩展名**的选项。一般来说，你可以通过 Windows 资源管理器，选择**文件夹选项**选项，取消勾选**隐藏已知文件类型的扩展名**复选框，然后点击**确认**将其关闭。

## 文件路径

为使文件间正常交互，应为每个文件提供访问路径，所以一个文件知道另一个文件的位置。

你可以在你的电脑上或从网上选择一个现有的图片，并在下面的步骤中使用它：

1. 将你之前选择的图片复制到你的 `images` 文件夹。

2. 打开你的 `index.html` 文件，并准确地将以下代码插入该文件中。当下不要对其感到困惑——我们将在本系列的后面更详细地研究这些结构。

   ```html
   <!doctype html>
   <html lang="en-US">
     <head>
       <meta charset="utf-8" />
       <meta name="viewport" content="width=device-width" />
       <title>My test page</title>
     </head>
     <body>
       <img src="" alt="My test image" />
     </body>
   </html>
   ```

3. 该行代码 `<img src="" alt="My test image">` 用于向页面中插入图片。我们需要告知 HTML 图片的位置。这张图片位于 *images* 目录下，与 `index.html` 处于同一目录。为了从 `index.html` 访问到我们的图像，我们需要的文件路径是 `images/your-image-filename`。例如，这里的图像叫做 `firefox-icon.png`，那么文件路径就是 `images/firefox-icon.png`。

4. 在 HTML 代码 `src=""` 的双引号之间插入文件路径。

5. 保存 HTML 文件，然后使用浏览器打开（双击该文件）。你应该看到新网页显示了新的图像！

   ![img1](E:\github\ph\web\img1.png)

*文件路径的一些通用规则：*

- 若引用的目标文件与 HTML 文件同级，只需直接使用文件名，例如：`my-image.jpg`。
- 要引用子目录中的文件，请在路径前面写上目录名，再加上一个正斜杠。例如：`subdirectory/my-image.jpg`。
- 若引用的目标文件位于 HTML 文件的**上级**，需要加上两个点。举个例子，如果 `index.html` 在 `test-site` 的一个子文件夹内，而 `my-image.jpg` 在 `test-site` 内，你可以使用`../my-image.jpg` 从 `index.html` 引用 `my-image.jpg`。
- 以上方法可以随意组合，比如：`../subdirectory/another-subdirectory/my-image.jpg`。

## HTML基础

超文本标记语言（英语：**H**yper**T**ext **M**arkup **L**anguage，简称：HTML）是一种用来结构化 Web 网页及其内容的标记语言。网页内容可以是：一组段落、一个重点信息列表、也可以含有图片和数据表。正如标题所示，本文将对 HTML 及其功能做一个基本介绍。

### HTML到底是什么？

HTML 不是一门编程语言，而是一种用于定义内容结构的*标记语言*。HTML 由一系列的**元素**组成，这些元素可以用来包围不同部分的内容，使其以某种方式呈现或者工作。一对**标签**可以为一段文字或者一张图片添加超链接，将文字设置为斜体，改变字号，等等。例如，键入下面一行内容：

```html
My cat is very grumpy
```

可以将这行文字封装成一个段落元素来使其在单独一行呈现：

HTMLCopy to Clipboard

```html
<p>My cat is very grumpy</p>
```

### HTML元素详解

让我们深入探索一下这个段落元素。

![grumpy-cat-small](E:\github\ph\web\grumpy-cat-small.png)

这个元素的主要部分有：

1. **开始标签**（Opening tag）：包含元素的名称（本例为 p），被大于号、小于号所包围。表示元素从这里开始或者开始起作用 —— 在本例中即段落由此开始。
2. **结束标签**（Closing tag）：与开始标签相似，只是其在元素名之前包含了一个斜杠。这表示着元素的结尾 —— 在本例中即段落在此结束。初学者常常会犯忘记包含结束标签的错误，这可能会产生一些奇怪的结果。
3. **内容**（Content）：元素的内容，本例中就是所输入的文本本身。
4. **元素**（Element）：开始标签、结束标签与内容相结合，便是一个完整的元素。

元素也可以有属性（Attribute）：

![grumpy-cat-attribute-small](E:\github\ph\web\grumpy-cat-attribute-small.png)

属性包含了关于元素的一些额外信息，这些信息本身不应显现在内容中。本例中，`class` 是属性名称，`editor-note` 是属性的值。`class` 属性可为元素提供一个标识名称，以便进一步为元素指定样式或进行其他操作时使用。

属性应该包含：

1. 在属性与元素名称（或上一个属性，如果有超过一个属性的话）之间的空格符。
2. 属性的名称，并接上一个等号。
3. 由引号所包围的属性值。

**备注：** 不包含 ASCII 空格（以及 `"` `'` ``` `=` `<` `>`）的简单属性值可以不使用引号，但是建议将所有属性值用引号括起来，这样的代码一致性更佳，更易于阅读。

### 嵌套元素

也可以将一个元素置于其他元素之中 —— 称作**嵌套**。要表明猫咪非常暴躁，可以将“very”用`<strong>`元素包围，爆字将突出显示：

```html
<p>My cat is <strong>very</strong> grumpy.</p>
```

必须保证元素嵌套次序正确：本例首先使用`<p>` 标签，然后是`<strong>` 标签，因此要先结束`<strong>`标签，最后再结束`<p>`标签。

元素必须正确地开始和结束，才能清楚地显示出正确的嵌套层次

### 空元素

不包含任何内容的元素称为空元素，比如`<img>`元素

```html
<img src="images/firefox-icon.png" alt="My test image" />
```

本元素包含两个属性，但是并没有 `</img>` 结束标签，元素里也没有内容。这是因为图像元素不需要通过内容来产生效果，它的作用是向其所在的位置嵌入一个图像。

###HTML文档详解

完整的 HTML 页面

```html
<!doctype html>
<html lang="en-US">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width" />
    <title>My test page</title>
  </head>
  <body>
    <img src="images/firefox-icon.png" alt="My test image" />
  </body>
</html>
```

这里有：

- `<!DOCTYPE html>`——文档类型。这是必不可少的开头。混沌初分，HTML 尚在襁褓（大约是 1991/92 年）之时，这个元素用来关联 HTML 编写规范，以供自动查错等功能所用。而在当今，它作用有限，可以说**仅用于保证文档正常读取**。现在知道这些就足够了。
- `<html></html>`——`<html>`元素。该元素包含整个页面的所有内容，有时候也称作根元素。里面也包含了 `lang` 属性，写明了页面的主要语种。
- `<head></head>`——`<head>`元素。所有那些你加到页面中，且不向看客展示的页面成员，都以这个元素为容器。其中包含诸如提供给搜索引擎的关键字和页面描述、用作风格化页面的 CSS、字符集声明等等。
- `<meta charset="utf-8">`——该元素指明你的文档使用 UTF-8 字符编码，UTF-8 包括世界绝大多数书写语言的字符。它基本上可以处理任何文本内容。以它为编码还可以避免以后出现某些问题，没有理由再选用其他编码。
- `<meta name="viewport" content="width=device-width">`——视口元素，可以确保页面以视口宽度进行渲染，避免移动端浏览器上因页面过宽导致缩放。
- `<title></title>`——`<title>`元素。该元素设置页面的标题，显示在浏览器标签页上，也作为收藏网页的描述文字。
- `<body></body>`——`<body>`元素。该元素包含期望让用户在访问页面时看到的*全部*内容，包括文本、图像、视频、游戏、可播放的音轨或其他内容。

### 图像

重温一下`<img>`元素：

HTMLCopy to Clipboard

```html
<img src="images/firefox-icon.png" alt="My test image" />
```

像之前所讲，该元素通过包含图像文件路径的地址属性 `src`，可在所在位置嵌入图像。

该元素还包括一个替换文字属性 `alt`，是图像的描述内容，用于当图像不能被用户看见时显示，不可见的原因可能是：

1. 用户有视觉障碍。视障用户可以使用屏幕阅读器来朗读 `alt` 属性的内容。

2. 有些错误使图像无法显示。可以试着故意将 `src` 属性里的路径改错。保存并刷新页面就可以在图像位置看到：

   ![alt-text-example](E:\github\ph\web\alt-text-example.png)

`alt` 属性的关键字即“描述文本”。`alt` 文本应向用户完整地传递图像要表达的意思。

### 标记文本

本段包含了一些最常用的文本标记 HTML 元素。

**标题（Heading）**

标题元素可用于指定内容的标题和子标题。就像一本书的书名、每章的大标题、小标题，等。HTML 文档也是一样。HTML 包括六个级别的标题，h1一h6般最多用到 3-4 级标题。

```html
<h1>主标题</h1>
<h2>顶层标题</h2>
<h3>子标题</h3>
<h4>次子标题</h4>
```

**段落（Paragraph）**

如上文所讲,`<p>`元素是用来指定段落的。通常用于指定常规的文本内容：

```html
<p>这是一个段落</p>
```

**列表（list）**

Web 上的许多内容都是列表，HTML 有一些特别的列表元素。标记列表通常包括至少两个元素。最常用的列表类型为：

1. **无序列表**（Unordered List）中项目的顺序并不重要，就像购物列表。用一个 `<ul>`元素包围。
2. **有序列表**（Ordered List）中项目的顺序很重要，就像烹调指南。用一个 `<ol>`元素包围。

列表的每个项目用一个列表项目（List Item）元素 `<li>`包围。

比如，要将下面的段落片段改成一个列表：

```html
<p>
  At Mozilla, we're a global community of technologists, thinkers, and builders
  working together…
</p>
```

可以这样更改标记：

```html
<p>At Mozilla, we're a global community of</p>

<ul>
  <li>technologists</li>
  <li>thinkers</li>
  <li>builders</li>
</ul>

<p>working together…</p>
```

### 链接

链接非常重要 — 它们赋予 Web 网络属性。要植入一个链接，我们需要使用一个简单的元素 — `<a>`— a 是 "anchor" （锚）的缩写。要将一些文本添加到链接中，只需如下几步：

1. 选择一些文本。比如“Mozilla Manifesto”。

2. 将文本包含在`<a>`元素内，就像这样：

   ```html
   <a>Mozilla Manifesto</a>
   ```

3. 为此`<a>`元素添加一个`<href>`属性，就像这样：

   ```html
   <a href="">Mozilla Manifesto</a>
   ```

4. 把属性的值设置为所需网址：

   ```html
   <a href="https://www.mozilla.org/zh-CN/about/manifesto/"
     >Mozilla Manifesto</a
   >
   ```

如果网址开始部分省略了 `https://` 或者 `http://`，可能会得到错误的结果。在完成一个链接后，可以试着点击它来确保指向正确。

**备注：** `href` 这个名字可能开始看起来有点令人费解，代表超文本引用（ **h**ypertext **ref**erence）。

##CSS基础

CSS（Cascading Style Sheets，层叠样式表）是为 web 内容添加样式的代码。本节将介绍 CSS 的基础知识，并解答像这样的问题：怎样将文本设置为红色？怎样将内容显示在屏幕的特定位置？怎样用背景图片或颜色来装饰网页？

### 什么是CSS？

和 HTML 类似，CSS 也不是真正的编程语言，甚至不是标记语言。**CSS 是一门样式表语言**，这也就是说人们可以用它来选择性地为 HTML 元素添加样式。举例来说，以下 CSS 代码选择了所有的段落文字，并将它们设置为红色。

```css
p {
  color: red;
}
```

**“CSS规则集”**详解

让我们来剖析一下红色段落文字的 CSS 代码，了解它是如何工作的：

![css-declaration-small](E:\github\ph\web\css-declaration-small.png)

整个结构称为**规则集**（*规则集*通常简称*规则*），注意各个部分的名称：

- 选择器（Selector）

  HTML 元素的名称位于规则集开始。它选择了一个或多个需要添加样式的元素（在这个例子中就是`<p>`元素）。要给不同元素添加样式，只需要更改选择器。

- 声明（Declaration）

  一个单独的规则，如 `color: red;` 用来指定添加样式元素的**属性**。

- 属性（Properties）

  改变 HTML 元素样式的途径（本例中 `color` 就是`<p>`元素的属性）。CSS 中，由编写人员决定修改哪个属性以改变规则。

- 属性的值（Property value）

  在属性的右边，冒号后面即**属性的值**，它从指定属性的众多外观中选择一个值（我们除了 `red` 之外还有很多属性值可以用于 `color` ）。



注意其他重要的语法：

- 除了选择器部分，每个规则集都应该包含在成对的大括号里（`{}`）。
- 在每个声明里要用冒号（`:`）将属性与属性值分隔开。
- 在每个规则集里要用分号（`;`）将各个声明分隔开。

如果要同时修改多个属性，只需要将它们用分号隔开，就像这样：

```css
p {
  color: red;
  width: 500px;
  border: 1px solid black;
}
```

**选择多个元素**

也可以选择多种类型的元素并为它们添加一组相同的样式。将不同的选择器用逗号分开。例如：

```css
p,
li,
h1 {
  color: red;
}
```

**不同类型的选择器**

选择器有许多不同的类型。上面只介绍了**元素选择器**，用来选择 HTML 文档中给定的元素。但是选择操作可以更加具体。下面是一些常用的选择器类型：

| 选择器名称                           | 选择的内容                                                   | 示例                                                         |
| :----------------------------------- | :----------------------------------------------------------- | :----------------------------------------------------------- |
| 元素选择器（也称作标签或类型选择器） | 所有指定类型的 HTML 元素                                     | `p` 选择 `<p>`                                               |
| ID 选择器                            | 具有特定 ID 的元素。单一 HTML 页面中，每个 ID 只对应一个元素，一个元素只对应一个 ID | `#my-id` 选择 `<p id="my-id">` 或 `<a id="my-id">`           |
| 类选择器                             | 具有特定类的元素。单一页面中，一个类可以有多个实例           | `.my-class` 选择 `<p class="my-class">` 和 `<a class="my-class">` |
| 属性选择器                           | 拥有特定属性的元素                                           | `img[src]` 选择 `<img src="myimage.png">` 但不是 `<img>`     |
| 伪类选择器                           | 特定状态下的特定元素（比如鼠标指针悬停于链接之上）           | `a:hover` 选择仅在鼠标指针悬停在链接上时的 `<a>` 元素        |

选择器种类远远不止这些……

### 字体和文本

在探索了一些 CSS 基础后，我们来把更多规则和信息添加至 `style.css` 中，从而让示例更美观。

**备注：** CSS 文档中所有位于 `/*` 和 `*/` 之间的内容都是 **CSS 注释**。浏览器在渲染代码时会忽略注释。CSS 注释是一种让你写下关于你的代码或逻辑的有用注解的方式。

接下来为 HTML 主体内的元素（`h1` `<li>` `<p>`）设置字体大小。我们也将标题居中显示。最后，扩充下方的第二个规则集，为正文设置行高和字间距，从而提高页面的可读性。

```css
<!doctype html>
<html lang="en-US">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width" />
    <title>My test page</title>
</head>

<body>
    <h1>h1的标签</h1>
    <p>p段落</p>
    <ul>
        <li>li标签</li>
    </ul>
</body>
</html>
<style>
   h1 {
  font-size: 60px;
  text-align: center;
}

  p,
  li {
  font-size: 10px;
  line-height: 2;
  letter-spacing: 1px;
  color:aqua;
  } 
</style>

```

![img2](E:\github\ph\web\img2.png)

### css：一切皆盒子

编写 CSS 时你会发现，你的工作好像是围绕着一个一个盒子展开的——设置尺寸、颜色、位置，等等。页面里大部分 HTML 元素都可以被看作若干层叠的盒子。

CSS 布局主要是基于*盒子模型*。在你的页面上占用空间的每个盒子都有类似的属性：

- `padding`（内边距）：是指内容周围的空间。在下面的例子中，它是段落文本周围的空间。
- `border`（边框）：是紧接着内边距的线。
- `margin`（外边距）：是围绕元素边界外侧的空间。

![box-model](E:\github\ph\web\box-model.png)

这里还使用了：

- `width`：元素的宽度
- `background-color`：元素内容和内边距底下的颜色
- `color`：元素内容（通常是文本）的颜色
- `text-shadow`：为元素内的文本设置阴影
- `display`：设置元素的显示模式

**更改页面颜色**

```css
 html {
    background-color: #00539f;
}
```

![img3](E:\github\ph\web\img3.png)

**文档体样式**

```css
body {
  width: 600px;
  margin: 0 auto;
  background-color: #ff9500;
  padding: 0 20px 20px 20px;
  border: 5px solid black;
}
```

这里有对于`<body>`元素的几条声明，我们来逐条查看：

- `width: 600px;` 强制页面永远保持 600 像素宽。
- `margin: 0 auto;` 当你在 `margin` 或 `padding` 这样的属性上设置两个值时，第一个值影响元素的*上下*方向（在这个例子中设置为 `0`）；第二个值影响*左右*方向。(这里，`auto` 是一个特殊的值，它将可用的水平空间平均分配给左和右）。如 [Margin 语法](https://developer.mozilla.org/zh-CN/docs/Web/CSS/margin#语法)中所记载的那样，你也可以使用一个、两个、三个或四个值。
- `background-color: #FF9500;` 如前文所述，指定元素的背景颜色。我们给 body 用了一种略微偏红的橘色以与深蓝色的`<html>`元素形成反差，你也可以尝试其他颜色。
- `padding: 0 20px 20px 20px;` 我们给内边距设置了四个值来让内容四周产生一点空间。这一次我们不设置上方的内边距，设置右边，下方，左边的内边距为 20 像素。值以上、右、下、左的顺序排列。与 `margin` 一样，你也可以像 [Padding 语法](https://developer.mozilla.org/zh-CN/docs/Web/CSS/padding#语法)中所记载的那样，使用一个、两个、三个或四个值。
- `border: 5px solid black;` 这是为边框的宽度、样式和颜色设置的值。在本例中，它是一个在主体的所有侧面的 5 像素宽的纯黑色边框。

![img4](E:\github\ph\web\img4.png)

**定位页面主标题并添加样式**

```css
h1 {
  margin: 0;
  padding: 20px 0;
  color: #00539f;
  text-shadow: 3px 3px 1px black;
}
```

你可能已经注意到，在正文的顶部有一个难看的间隙。这是因为浏览器对 [h1](https://developer.mozilla.org/zh-CN/docs/Web/HTML/Element/Heading_Elements) 元素（以及其他元素）应用了默认样式。这可能看起来是个坏主意，但其目的是为没有样式的页面提供基本的可读性。为了消除这种间隙，我们用设置 `margin: 0;` 来覆盖浏览器的默认样式。

接下来，我们将标题的顶部和底部内边距设置为 20 像素。

之后，我们将标题文本设置为与 HTML 背景颜色相同的颜色。

最后，`text-shadow` 对元素的文本内容施加阴影。它的四个值是：

- 第一个像素值设置阴影与文本的**水平偏移量**：它横移的距离。
- 第二个像素值设置阴影与文本的**垂直偏移量**：它向下移动的距离。
- 第三个像素值设置阴影的**模糊半径**。一个更大的值会产生一个更模糊的阴影。
- 第四个值设置阴影的基色。

试着用不同的值进行试验，看看它是如何改变外观的。

![img5](E:\github\ph\web\img5.png)

**图像居中**

```css
img {
  display: block;
  margin: 0 auto;
}
```

![img6](E:\github\ph\web\img6.png)

最后，我们把图像居中来使页面更美观。可以复用 body 的 `margin: 0 auto`，但有一些差异，需要额外的设置来使 CSS 发挥作用

`<body>`元素是**块级**元素，意味着它占据了页面的空间并且能够赋予外边距和其他改变间距的值。而图片是**行级**元素，不具备块级元素的一些功能。所以为了使图像有外边距，我们必须使用 `display: block` 给予其块级行为。

## JavaScript基础

JavaScript 是一门编程语言，可为网站添加交互功能（例如：游戏、动态样式、动画以及在按下按钮或收到表单数据时做出的响应等）。本文介绍了 JavaScript 的精彩之处和主要用途。

### JavaScript到底是什么？

JavaScript（缩写：JS）是一门完备的动态编程语言。当应用于HTML文档时，可为网站提供动态交互特性。由布兰登·艾克（Brendan Eich，Mozilla 项目、Mozilla 基金会和 Mozilla 公司的联合创始人）发明。

JavaScript 的应用场合极其广泛，简单到幻灯片、照片库、浮动布局和响应按钮点击，复杂到游戏、2D/3D 动画、大型数据库驱动程序等等。

JavaScript 相当简洁，却非常灵活。开发者们基于 JavaScript 核心编写了大量实用工具，可以使 开发工作事半功倍。其中包括：

- 浏览器应用程序接口（[API](https://developer.mozilla.org/zh-CN/docs/Glossary/API)）—— 浏览器内置的 API 提供了丰富的功能，比如：动态创建 HTML 和设置 CSS 样式、从用户的摄像头采集处理视频流、生成 3D 图像与音频样本等等。
- 第三方 API —— 让开发者可以在自己的站点中整合其他内容提供者（Twitter、Facebook 等）提供的功能。
- 第三方框架和库 —— 用来快速构建网站和应用。

### "Hello World!"实例

读到这里你一定很激动，诚然 —— JavaScript 是最振奋人心的 Web 技术之一，而且在娴熟驾驭之后，你的网站在功能和创新力上将达到一个新的维度。

然而，JavaScript 比 HTML 和 CSS 学习起来更加复杂一点，所以必须一步一个脚印地学习。首先，来看看如何在页面中添加一些基本的 JavaScript 脚本来建造一个“Hello world!”示例。

1. 首先，打开你的测试站点，创建一个名为 `scripts` 的文件夹。然后在其中创建一个名为 main.js 的文件。

2. 下一步，在`index.html`文件</body> 标签前的新行添加以下代码

   ```html
   <script src="scripts/main.js" defer></script>
   ```

3. 与 CSS 的`<link>`元素类似，它将 JavaScript 引入页面以作用于 HTML（以及 CSS 等页面上所有内容）：

4. 现在将以下代码添加到`main.js`文件中：

   ```javascript
   let myHeading = document.querySelector("h1");
   myHeading.textContent = "Hello world!";
   ```

5. 最后，保存 HTML 和 JavaScript 文件，用浏览器打开 `index.html`。可以看到如下内容：

![img7](E:\github\ph\web\img7.png)

全部代码：

index.html

```html
<!doctype html>
<html lang="en-US">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width" />
    <title>My test page</title>
    <link type="text/css" rel="stylesheet" href="styles/style.css" /> 
</head>
<body>
<h1> </h1>
<script src="scripts/main.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>

```

main.js

```javascript
    let myHeading = document.querySelector("h1");
    myHeading.textContent = "Hello world!";
```

**备注：** 我们将`<script>`放在 HTML 文件的底部附近的原因是浏览器会按照代码在文件中的顺序加载 HTML。如果先加载的 JavaScript 期望修改其下方的 HTML，那么它可能由于 HTML 尚未被加载而失效。因此，将 JavaScript 代码放在 HTML 页面的底部附近通常是最好的策略。

**发生了什么？**

JavaScript 把页面的标题改成了“Hello world!” 。首先用 [`querySelector()`](https://developer.mozilla.org/zh-CN/docs/Web/API/Document/querySelector) 函数获取标题的引用，并把它储存在 `myHeading` 变量中。这与 CSS 选择器的用法非常相像：若要对某个元素进行操作，首先得选择它。

之后，把 `myHeading` 变量的属性 [`textContent`](https://developer.mozilla.org/zh-CN/docs/Web/API/Node/textContent) （标题内容）修改为“Hello world!” 。

**备注：** 上面用到的两个函数都来自 [文档对象模型 (DOM) API](https://developer.mozilla.org/zh-CN/docs/Web/API/Document_Object_Model)，均用于控制文档。

### JavaScript快速入门

我们来学习一些 JavaScript 的核心特性，从而更好地理解它的运行机制。学习这些知识很有意义，因为这些原理普遍适用于所有编程语言，掌握好它们，可以做到融会贯通。

**变量**(Variable)

[变量](https://developer.mozilla.org/zh-CN/docs/Glossary/Variable) 是存储值的容器。要声明一个变量，先输入关键字 `let` 或 `var`，然后输入合适的名称：

```javascript
let myVariable;
```

**备注：** 行末的分号表示当前语句结束，不过只有在单行内需要分割多条语句时，这个分号才是必须的。然而，一些人认为每条语句末尾加分号是一种好的风格。分号使用规则的更多细节请参阅 [JavaScript 分号使用指南](http://news.codecademy.com/your-guide-to-semicolons-in-javascript/)（英文页面）。

**备注：** 几乎任何内容都可以作为变量名，但还是有一些限制（请参阅 [变量命名规则](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Guide/Grammar_and_types#变量)）。如果你不确定，还可以 [验证变量名](https://mothereff.in/js-variables) 是否有效。

**备注：** JavaScript 对大小写敏感，`myVariable` 和 `myvariable` 是不同的。如果代码出现问题了，先检查一下大小写！

**备注：** 想要了解更多关于 `var` 和 `let` 的不同点，可以参阅 [var 与 let 的区别](https://developer.mozilla.org/zh-CN/docs/Learn/JavaScript/First_steps/Variables#var_与_let_的区别)。

变量定义后可以进行赋值：

```javascript
myVariable = "李雷";
```

也可以将定义、赋值操作写在同一行：

```javascript
let myVariable = "李雷";
```

可以直接通过变量名取得变量的值：

```javascript
myVariable;
```

变量在赋值后是可以更改的：

```javascript
let myVariable = '李雷';
myVariable = '韩梅梅';
```

注意变量可以有不同的数据类型：

| 变量                                                         | 解释                                                         | 示例                                                         |
| :----------------------------------------------------------- | :----------------------------------------------------------- | :----------------------------------------------------------- |
| [String](https://developer.mozilla.org/zh-CN/docs/Glossary/String) | 字符串（一串文本）：字符串的值必须用引号（单双均可，必须成对）括起来。 | `let myVariable = '李雷';`                                   |
| [Number](https://developer.mozilla.org/zh-CN/docs/Glossary/Number) | 数字：无需引号。                                             | `let myVariable = 10;`                                       |
| [Boolean](https://developer.mozilla.org/zh-CN/docs/Glossary/Boolean) | 布尔值（真 / 假）： `true`/`false` 是 JS 里的特殊关键字，无需引号。 | `let myVariable = true;`                                     |
| [Array](https://developer.mozilla.org/zh-CN/docs/Glossary/Array) | 数组：用于在单一引用中存储多个值的结构。                     | `let myVariable = [1, '李雷', '韩梅梅', 10];` 元素引用方法：`myVariable[0]`, `myVariable[1]` …… |
| [Object](https://developer.mozilla.org/zh-CN/docs/Glossary/Object) | 对象：JavaScript 里一切皆对象，一切皆可储存在变量里。这一点要牢记于心。 | `let myVariable = document.querySelector('h1');` 以及上面所有示例都是对象。 |

**注释**

```javascript
/*
这里的所有内容
都是注释。
*/
```

```javascript
// 这是一条注释。（单行）
```

**运算符**

[运算符](https://developer.mozilla.org/zh-CN/docs/Glossary/Operator) 是一类数学符号，可以根据两个值（或变量）产生结果。以下表格中介绍了一些最简单的运算符，可以在浏览器控制台里尝试一下后面的示例。

**备注：** 这里说“根据**两个**值（或变量）产生结果”是不严谨的，计算两个变量的运算符称为“二元运算符”，还有一元运算符和三元运算符，下表中的“取非”就是一元运算符。

| 运算符     | 解释                                                         | 符号          | 示例                                                         |
| :--------- | :----------------------------------------------------------- | :------------ | :----------------------------------------------------------- |
| 加         | 将两个数字相加，或拼接两个字符串。                           | `+`           | `6 + 9;"Hello " + "world!";`                                 |
| 减、乘、除 | 这些运算符操作与基础算术一致。只是乘法写作星号，除法写作斜杠。 | `-`, `*`, `/` | `9 - 3;8 * 2; //乘法在 JS 中是一个星号9 / 3;`                |
| 赋值运算符 | 为变量赋值（你之前已经见过这个符号了）                       | `=`           | `let myVariable = '李雷';`                                   |
| 等于       | 测试两个值是否相等，并返回一个 `true`/`false` （布尔）值。   | `===`         | `let myVariable = 3;myVariable === 4; // false`              |
| 不等于     | 和等于运算符相反，测试两个值是否不相等，并返回一个 `true`/`false` （布尔）值。 | `!==`         | `let myVariable = 3;myVariable !== 3; // false`              |
| 取非       | 返回逻辑相反的值，比如当前值为真，则返回 `false`。           | `!`           | 原式为真，但经取非后值为 `false`： `let myVariable = 3;!(myVariable === 3); // false` |

运算符种类远不止这些，不过目前上表已经够用了。完整列表请参阅 [表达式和运算符](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Operators)。

**备注：** 不同类型数据之间的计算可能出现奇怪的结果，因此必须正确引用变量，才能得出预期结果。比如在控制台输入 `"35" + "25"`，为什么不能得到 `60`？因为引号将数字转换成了字符串，所以结果是连接两个字符串而不是把两个数字相加。输入 `35 + 25` 才能得到正确结果。

**条件语句**

条件语句是一种代码结构，用来测试表达式的真假，并根据测试结果运行不同的代码。一个常用的条件语句是 `if ... else`。下面是一个示例：

```javascript
let iceCream = "chocolate";
if (iceCream === "chocolate") {
  alert("我最喜欢巧克力冰激淋了。");
} else {
  alert("但是巧克力才是我的最爱呀……");
}
```

`if ( ... )` 中的表达式进行测试，用（上文所提到的）等于运算符来比较变量 `iceCream` 与字符串 `'chocolate'` 是否相等。如果返回 `true`，则运行第一个代码块；如果返回 `false`，则跳过第一块直接运行 `else` 之后的第二个代码块。

**函数（Function）**

[函数](https://developer.mozilla.org/zh-CN/docs/Glossary/Function) 用来封装可复用的功能。如果没有函数，一段特定的操作过程用几次就要重复写几次，而使用函数则只需写下函数名和一些简短的信息。之前已经涉及过一些函数，比如：

```javascript
let myVariable = document.querySelector("h1");
```

```javascript
alert("hello!");
```

`document.querySelector` 和 `alert` 是浏览器内置的函数，随时可用。

如果代码中有一个类似变量名后加小括号 `()` 的东西，很可能就是一个函数。函数通常包括[参数](https://developer.mozilla.org/zh-CN/docs/Glossary/Argument)，参数中保存着一些必要的数据。它们位于括号内部，多个参数之间用逗号分开。

比如， `alert()` 函数在浏览器窗口内弹出一个警告框，还应为其提供一个字符串参数，以告诉它警告框里要显示的内容。

好消息是：人人都能定义自己的函数。下面的示例是为两个参数进行乘法运算的函数：

```javascript
function multiply(num1, num2) {
  let result = num1 * num2;
  return result;
}
```

尝试在控制台运行这个函数，不妨多试几组参数，比如：

```javascript
multiply(4, 7);
multiply(20, 20);
multiply(0.5, 3);
```

**备注：** [`return`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Statements/return) 语句告诉浏览器当前函数返回 `result` 变量。这是一点很有必要，因为函数内定义的变量只能在函数内使用。这叫做变量的 [作用域](https://developer.mozilla.org/zh-CN/docs/Glossary/Scope)。（详见 [变量作用域](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Guide/Grammar_and_types#variable_scope)。）

**事件**

事件能为网页添加真实的交互能力。它可以捕捉浏览器操作并运行一些代码做为响应。最简单的事件是[点击事件](https://developer.mozilla.org/zh-CN/docs/Web/API/Element/click_event)，鼠标的点击操作会触发该事件。可尝试将下面的代码输入到控制台，然后点击页面的任意位置：

```javascript
document.querySelector("html").addEventListener("click", function () {
  alert("别戳我，我怕疼。");
});
```

将事件与元素绑定有许多方法。在这里选用了`html`元素，然后调用了它的 [`addEventListener()`](https://developer.mozilla.org/zh-CN/docs/Web/API/EventTarget/addEventListener) 方法，将事件名称（`'click'`）以及其回调函数（当事件发生时，调用该函数）传入该函数中作为调用参数。

刚刚我们传递给 `addEventListener()` 的函数被称为*匿名函数*，因为它没有名字。匿名函数还有另一种我们称之为*箭头函数*的写法，箭头函数使用 `() =>` 代替 `function ()`：

```javascript
document.querySelector("html").addEventListener("click", () => {
  alert("别戳我，我怕疼。");
});
```

###**完善实例网页**

现在你已经具备了一些 JavaScript 基础，下面来为示例网页添加一些更酷的特性。

**添加一个图像切换器**

这里将用新的 DOM API 为网页添加另一张图片，并用 JavaScript 使图片在点击时进行切换。

1. 首先，找到另一张你想要在你的页面上展示的图片，且尺寸与第一张图片尽可能相同。
2. 将这张图片储存在你的`images`目录下。
3. 将图片重命名为'img2.png'（去掉引号）。
4. 打开 `main.js` 文件，输入下面的 JavaScript 代码 ( 请删除刚才的 "hello world" 脚本)：

```javascript
let myImage = document.querySelector("img");

myImage.onclick = function () {
  let mySrc = myImage.getAttribute("src");
  if (mySrc === "images/img1.jpg") {
    myImage.setAttribute("src", "images/img2.jpg");
  } else {
    myImage.setAttribute("src", "images/img1.jpg");
  }
};
```

5. 保存所有文件并用浏览器打开 `index.html` 。点击图片可以发现它能够切换了！

   ![img8](E:\github\ph\web\img8.png)

![img9](E:\github\ph\web\img9.png)

这里首先把`<img>`元素的引用存放在 `myImage` 变量里。然后将这个变量的 `onclick` 事件与一个匿名函数绑定。每次点击图片时：

1. 获取这张图片的 `src` 属性值。
2. 用一个条件句来判断`src`的值是否等于原始图像的路径：
   1. 如果是，则将 `src` 的值改为第二张图片的路径，并在`<img>`内加载该图片。
   2. 如果不是（意味着它已经修改过）, 则把 `src` 的值重新设置为原始图片的路径，即原始状态。

**添加个性化欢迎信息**

下面来添加另一段代码，在用户初次进入站点时将网页的标题改成一段个性化欢迎信息（即在标题中添加用户的名字）。名字信息会由 [Web Storage API](https://developer.mozilla.org/zh-CN/docs/Web/API/Web_Storage_API) 保存下来，即使用户关闭页面之后再重新打开，仍可得到之前的信息。还会添加一个选项，可以根据需要改变用户名字以更新欢迎信息

1. 打开`index.html`，在`<script>`标签前添加以下代码，将在页面底部显示一个“切换用户”字样的按钮：

   ```html
   <button>切换用户</button>
   ```

2. 将以下 JavaScript 代码原封不动添加到`main.js`文件底部，将获取新按钮和标题的引用，并保存至变量中：

   ```javascript
   let myButton = document.querySelector("button");
   let myHeading = document.querySelector("h1");
   ```

3. 然后添加以下函数来设置个性化欢迎信息。（函数需要在调用后生效，下文中提供了两种对该函数的调用方式）

   ```javascript
   function setUserName() {
     let myName = prompt("请输入你的名字。");
     localStorage.setItem("name", myName);
     myHeading.textContent = "Mozilla 酷毙了，" + myName;
   }
   ```

   该函数首先调用了`prompt()`函数，与`alert()`类似会弹出一个对话框。但是这里需要用户输入数据，并在确定后将数据存储在`myName`

   变量里。接下来将调用`localStorage`API，它可以将数据存储在浏览器中供后续获取。这里用`localStorage`的`setItem()`函数来创建一个

   `'name'`数据项，并把`myName`变量复制给它。最后将`textContent`属性设置为一个欢迎字符串加上这个新设置的名字。

4. 接下来，添加以下的 `if ... else` 块。我们可以称之为初始化代码，因为它在页面初次读取时进行构造工作：

```javascript
if (!localStorage.getItem("name")) {
  setUserName();
} else {
  let storedName = localStorage.getItem("name");
  myHeading.textContent = "Mozilla 酷毙了，" + storedName;
}
```

这里首次使用了取非运算符（逻辑非，用 `!` 表示）来检测 `'name'` 数据是否存在。若不存在，调用 `setUserName()` 创建。若存在（即用户上次访问时设置过），调用 `getItem()` 获取保存的名字，像上文的 `setUserName()` 那样设置 `textContent`。

5. 最后，为按钮设置 onclick 事件处理器。按钮按下时运行 setUserName() 函数。这样用户就可以通过按这个按钮来自由设置新名字了：

```javascript
myButton.onclick = function () {
  setUserName();
};
```

第一次访问网页时，页面将询问用户名并发出一段个性化的信息。可随时点击按钮来改变用户名。告诉你一个额外的福利，因为用户名是保存在 `localStorage` 里的，网页关闭后也不会丢失，所以重新打开浏览器时所设置的名字信息将依然存在:)

**用户名为null？**

运行示例代码，弹出输入用户名的对话框，试着按下 取消 按钮。此时标题会显示为“Mozilla 酷毙了，null”。这是因为取消提示对话框后值将设置为 `null`，这是 JavaScript 中的一个特殊值，表示引用不存在。

也可以不输入任何名字直接按 确认，你的标题会显示为“Mozilla 酷毙了，”，原因显而易见。

要避免这些问题，应该更新 `setUserName()` 来检查用户是否输入了 `null` 或者空名字：

```javascript
function setUserName() {
  let myName = prompt("请输入你的名字。");
  if (!myName) {
    setUserName();
  } else {
    localStorage.setItem("name", myName);
    myHeading.textContent = "Mozilla 酷毙了，" + myName;
  }
}
```

用人话说就是：如果 `myName` 没有值或值为 `null`，就再次从头运行`setUserName()`。如果有值（上面的表达式结果不为真），就把值存储到 `localStorage` 并且设置标题。

## 发布网站

在你已经写好了代码并且整理好了你网站的全部文件后，你需要将它们全部上线，这样别人才能看到。这篇文章将向你展示如何轻松地将你简单的示例代码传到网上。

### 有哪些方法可供选择？

从初学者的视角讨论以下三种常见的方式的利弊，然后带你看看我们将要使用的一种方法。

**获取主机服务和域名**

如果你想要完全控制你发布的网页，那么你将需要花钱购置：

- 主机服务——在主机服务提供商的 [Web 服务器](https://developer.mozilla.org/zh-CN/docs/Learn/Common_questions/Web_mechanics/What_is_a_web_server)上租用文件空间。将你网站的文件上传到这里，然后服务器会提供 Web 用户需求的内容。

- [域名](https://developer.mozilla.org/zh-CN/docs/Learn/Common_questions/Web_mechanics/What_is_a_domain_name)——一个可以让人们访问的独一无二的地址，比如 `http://www.mozilla.org` 或 `http://www.bbc.co.uk`。你可以从**域名注册商**租借域名。

  许多专业的网站通过这种方法接入互联网。

此外，你将需要一个 [文件传输协议](https://developer.mozilla.org/zh-CN/docs/Glossary/FTP) 程序 ( 点击[钻研在网络上做某些事情要花费多少：软件](https://developer.mozilla.org/zh-CN/docs/Learn/Common_questions/Tools_and_setup/How_much_does_it_cost#软件)查看详细信息 ) 来将网站文件上传到服务器。不同的 FTP 程序涵盖了不同的范围，但是你通常需要使用主机服务提供商给你的详细信息（比如用户名、密码、主机名）登录到 Web 服务器。然后程序在两个窗口里分别显示本地文件和服务器文件，这样你就可以在它们之间进行传输：

![ftp](E:\github\ph\web\ftp.jpg)

寻找主机服务和域名的建议

- 我们不会推荐任何商业化的主机公司。要找到主机公司和域名注册商，只需要搜索 "网络主机服务" 和 "域名" 来找到一家出售域名的公司。所有这种类型的公司都允许你查看你想要的域名是否可用。
- 你的家庭或办公 [网络服务提供商](https://developer.mozilla.org/zh-CN/docs/Glossary/ISP) 可能会提供一些受限制的的小型主机空间。它们的能使用的功能都会受到限制，但是它们会非常适合你的第一个实验的——联系一下他们！
- 有一些免费服务比如 [Neocities](https://neocities.org/) ， [Blogspot](https://www.blogger.com/) ，和 [Wordpress](https://wordpress.com/) 。重复一遍，一分钱一分货，不过它们对于你的初次实验可能会是很理想的。免费服务大部分也不需要 FTP 软件来上传文件——你只需要将文件拖入到它们网页的界面里。
- 有时公司会打包提供主机服务和域名。

**使用在线工具如github或Google App Engine**

有一些工具能使你在线发布网站 :

- [GitHub](https://github.com/) 是一个“社交编程”网站。它允许你上传代码库并储存在 [Git](http://git-scm.com/) 版本控制系统里。然后你可以协作代码项目，系统是默认开源的，也就是说世界上任何人都可以找到你 GitHub 上的代码。去使用 GitHub，从中学习并且提高自己吧！你也可以对别人的代码那样做！这是一个非常重要、有用的社区，而且 Git/GitHub 是非常流行的 [版本控制系统](https://git-scm.com/book/zh/v2/起步-关于版本控制) — 大部分科技公司在工作中使用它。GitHub 有一个非常有用的特点叫 [GitHub pages](https://pages.github.com/)，允许你将网站代码放在网上。
- Google App Engine 是一个让你可以在 Google 的基础架构上构建和运行应用的强劲平台——无论你是需要从头开始构建多级 web 应用还是托管一个静态网站。参阅[How do you host your website on Google App Engine?](https://developer.mozilla.org/zh-CN/docs/Learn/Common_questions/Tools_and_setup/How_do_you_host_your_website_on_Google_App_Engine)以获取更多信息。

不同于大部分其他托管服务，这类工具通常是免费的，不过你只能使用有限的功能

**使用像CodePen这样基于Web的集成开发环境**

有许多 web 应用能够仿真一个网站开发环境。你可以在这种应用——通常只有一个标签页——里输入 HTML、CSS 和 JavaScript 代码然后像显示网页一样显示代码的结果。通常这些工具都很简单，对学习很有帮助，而且至少有免费的基本功能，它们在一个独特的网址显示你提交的网页。不过，这些应用的基础功能很有限，而且应用通常不提供空间来存储图像等内容。

使用一下以下几种工具，看看你最喜欢哪一个：

- [JSFiddle](https://jsfiddle.net/)
- [Glitch](https://glitch.com/)
- [JSBin](http://jsbin.com/)
- [CodePen](https://codepen.io/)

**通过github发布**

现在，让我们通过 Github 页面告诉你公布的你的代码是如此的简单。

1. 首先， [注册一个 GitHub 账号，](https://github.com/join) 并确认你的邮箱地址。
2. 接下来，你需要创建一个新的资源库 ( repository ) 来存放你的文件。
3. 在这个页面上，在 *Repository name* 输入框里输入 *username*.github.io，username 是你的用户名。比如，我们的朋友 bobsmith 会输入 *bobsmith.github.io。同时勾选* *Initialize this repository with a README*，然后点击 *Create repository*。

4. 然后，将你的网站文件夹里的内容拖拽到你的资源库 ( repository )，再点击Commit changes

   **备注：** 确保你的文件夹有一个 *index.html* 文件。

5. 现在将你的浏览器转到username.github.io 来在线查看你的网站。比如，如果用户名为 chrisdavidmills, 请转到chrisdavidmills.github.io

​      **备注：** 你的网站可能需要几分钟的时间才能投入使用。如果它不能立即工作，你可能需要等待几分钟，然后再试一次。

想要了解更多，请看 [GitHub Pages Help](https://help.github.com/categories/github-pages-basics/).
