

//Overload operators + and << for the class complex
//+ should add two complex numbers as (a+ib) + (c+id) = (a+c) + i(b+d)
//<< should print a complex number in the format "a+ib"
Complex operator+(const Complex &left, const Complex &right)
{
    Complex sum;
    sum.a = left.a + right.a;

    sum.b = left.b + right.b;

    return sum;
}

ostream &operator<<(ostream &out, const Complex &number)
{
    return out << number.a << "+i" << number.b;
}
