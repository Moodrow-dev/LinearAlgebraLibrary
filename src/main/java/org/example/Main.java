package org.example;


public class TestRunner {
    public static void main(String[] args) {
        System.out.println("🚀 Starting All Linear Algebra Tests\n");

        // Создаем экземпляры тестов и запускаем методы
        Vector2dTest vector2dTest = new Vector2dTest();
        Vector3dTest vector3dTest = new Vector3dTest();
        Vector4dTest vector4dTest = new Vector4dTest();
        Matrix2x2Test matrix2x2Test = new Matrix2x2Test();
        Matrix4x4Test matrix4x4Test = new Matrix4x4Test();
        IntegrationTest integrationTest = new IntegrationTest();

        try {
            vector2dTest.testVector2dAddition();
            vector2dTest.testVector2dConstructorValidation();
            vector2dTest.testVector2dLength();
            vector3dTest.testVector3dOperations();
            vector3dTest.testVector3dStandardCases();
            vector4dTest.testVector4dOperations();
            matrix2x2Test.testMatrix2x2Operations();
            matrix2x2Test.testMatrix2x2SpecialMatrices();
            matrix4x4Test.testMatrix4x4Operations();
            matrix4x4Test.testMatrix4x4ComplexMultiplication();
            integrationTest.testCompleteWorkflow();

            System.out.println("✅ All tests completed successfully!");

        } catch (Exception e) {
            System.out.println("❌ Test failed with exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}