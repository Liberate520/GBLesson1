package family_tree.addons

import family_tree.family.FamilyTree
import java.util.LinkedList
import java.util.regex.Pattern

class Addon:AddonInterface {
   var errors="";
    val mutableList= mutableListOf<String>()

    fun stringToInteger(text: String): Int {
        return try {
            text.toInt()
        } catch (e: Exception) {
           System.out.println(e)
         return 0
        }
    }




    fun add( value:String){
         mutableList.add(value)
    }
    fun clear( value:String){
        mutableList.clear()
    }


    fun removeDuplicates(text: String): String {
        val lines = text.split("\n")
        val uniqueLines = LinkedHashSet(lines)
            return uniqueLines.joinToString("\n")
    }



    override  fun findTextAll(text: String?, pattern: String?): Array<String> {

        val errors=StringBuilder()
        val builder=StringBuilder()
        val arr = mutableListOf<String>()
        try{

            val builder = StringBuilder()
            val ptrn = Pattern.compile(pattern!!)
            val match = ptrn.matcher(text!!)
            while (match.find()) {
                arr.add(match.group())
            }


        } catch (e: IndexOutOfBoundsException) {
            errors.append("Выход за размер массива:"+ e)
        } catch (e: IllegalArgumentException) {
            errors.append("IllegalArgumentException    " + e)
        } catch (e: IllegalStateException) {
            errors.append("IllegalStateException   " + e)
        } catch (e: NullPointerException) {
            errors.append("NullPointerException   " + e)
        } catch (e: ConcurrentModificationException) {
            errors.append("ConcurrentModificationException    " + e)
        }catch (e: NumberFormatException) {
            errors.append("NumberFormatException - if the string is not a valid representation of a number    " + e)

        }
        return arr.toTypedArray()

    }


    override  fun joinToString(separator:String):String{
        return mutableList.joinToString(separator)

    }
    override  fun  joinToString(arr:Array<String>, separator:String):String{
       return arr.joinToString(separator)

    }


    override  fun joinToString(link:LinkedList<Int>, separator:String):String{
        return link.joinToString(separator)

    }

    override fun findTextB(text: String?, pattern: String?): Boolean
    {
        val errors=StringBuilder()
        var res=false
        try {
            val ptrn = Pattern.compile(pattern!!)
            val match = ptrn.matcher(text!!)
            res=match.find()

        }catch( e:IndexOutOfBoundsException){errors.append("IndexOutOfBoundsException    "+e)}
        catch( e:IllegalArgumentException){errors.append("IllegalArgumentException    "+e)}
        catch( e:IllegalStateException){errors.append("IllegalStateException   "+e)}
        catch( e:NullPointerException){errors.append("NullPointerException   "+e)}
        catch( e:ConcurrentModificationException){errors.append("ConcurrentModificationException    "+e)}
        return res

    }
    override fun findText(text: String?, pattern: String?): String? {
        val res=StringBuilder()
        val errors=StringBuilder()
        try{
            val builder = StringBuilder()
            val ptrn = Pattern.compile(pattern!!)
            val match = ptrn.matcher(text!!)
            if (match.find()) {
                res.append(match.group())
            }

        }catch( e:IndexOutOfBoundsException){errors.append("IndexOutOfBoundsException    "+e)}
        catch( e:IllegalArgumentException){errors.append("IllegalArgumentException    "+e)}
        catch( e:IllegalStateException){errors.append("IllegalStateException   "+e)}
        catch( e:NullPointerException){errors.append("NullPointerException   "+e)}
        catch( e:ConcurrentModificationException){errors.append("ConcurrentModificationException    "+e)}
        res.append(errors.toString())

        return res.toString()

    }


}