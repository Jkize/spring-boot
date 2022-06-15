<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
    <title>Form student</title>

</head>

<body>

    <form:form action="processForm" modelAttribute="student">
        Firt name: <form:input path="firstName"/>
        <br><br>
        Last name <form:input path="lastName"/>
    
        <br><br>
        
        Country:
        <!-- <form:select path="country">
            <form:option value="Brazil" label="Brazil"/>
            <form:option value="France" label="France"/>
            <form:option value="Germany" label="Germany"/>
            <form:option value="India" label="India"/> 
        </form:select>
         -->
         <form:select path="country">
            <form:options items="${student.countryOptions}"/> 
        </form:select>

        <br><br>

        Favorite language: 
        
        Java <form:radiobutton path="favoriteLanguage" value="Java"/>
        
        C# <form:radiobutton path="favoriteLanguage" value="C#"/>
        
        PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>
        
        RUBY <form:radiobutton path="favoriteLanguage" value="RUBY"/>

        <br><br>

        Operating Systems:
        
        Linux <form:checkbox path="operationSystems" value="Linux"/>
        
        Mac Os <form:checkbox path="operationSystems" value="Mac Os"/>
        
        Win <form:checkbox path="operationSystems" value="Win"/>

        <br><br>

        <input type="submit" value="Submit"/>


    </form:form>



</body>

</html>