package org.example;


public class Main {
    public static void main(String[] args) {

        System.out.println("🚀 Starting All Linear Algebra Tests\n");

        // Создаем экземпляры тестов и запускаем методы
        Vector2dTest vector2dTest = new Vector2dTest();
        Vector3dTest vector3dTest = new Vector3dTest();
        Vector4dTest vector4dTest = new Vector4dTest();
        Matrix2x2Test matrix2x2Test = new Matrix2x2Test();
        Matrix3x3Test matrix3x3Test = new Matrix3x3Test();
        Matrix4x4Test matrix4x4Test = new Matrix4x4Test();
        IntegrationTests integrationTests = new IntegrationTests();

        try {
            vector2dTest.testVector2dOperations();
            vector3dTest.testVector3dOperations();
            vector3dTest.testVector3dStandardCases();
            vector4dTest.testVector4dOperations();
            matrix2x2Test.testMatrix2x2Operations();
            matrix2x2Test.testMatrix2x2SpecialMatrices();
            matrix3x3Test.testMatrix3x3Operations();
            matrix3x3Test.testMatrix3x3SpecialMatrices();
            matrix4x4Test.testMatrix4x4Operations();
            matrix4x4Test.testMatrix4x4ComplexMultiplication();
            integrationTests.testCompleteWorkflow();

            System.out.println("✅ All tests completed successfully!");

        } catch (Exception e) {
            System.out.println("❌ Test failed with exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}