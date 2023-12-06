package kr.mjc.jacob.basics.collections

fun main() {
  val s1 = """
    영변에 약산 진달래꽃 아름 따다 가실 길에 뿌리오리다
    가시는 걸음걸음 놓인 그 꽃을 사뿐히 즈려밟고 가시옵소서
    나 보기가 역겨워 가실 때에는 죽어도 아니 눈물 흘리오리다
    """.trimIndent()
  val s2 = """
    영변에 약산 진달래꽃 아름 따다 가실 길에 뿌리오리다
    가시는 걸음걸음 놓인 그 꽃을 사뿐히 즈려밟고 가시옵소서
    나 보기가 역겨워 가실 때에는 죽어도 아니 눈물 흘리오리다.
    """.trimIndent()

  println("s1.hashCode() = %x".format(s1.hashCode()))
  println("s2.hashCode() = %x".format(s2.hashCode()))
  println(s1)
  println(s1 === s2)
}